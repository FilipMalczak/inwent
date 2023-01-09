package com.github.filipmalczak.inwent.impl.location;

import com.github.filipmalczak.inwent.api.domain.LocationAPI;
import com.github.filipmalczak.inwent.api.model.domain.location.CreateLocationRequest;
import com.github.filipmalczak.inwent.api.model.domain.location.LocationDescriptor;
import com.github.filipmalczak.inwent.impl.common.Issues;
import com.github.filipmalczak.inwent.impl.common.Values;
import com.github.filipmalczak.inwent.impl.content.ContentConverter;
import com.github.filipmalczak.inwent.impl.content.ContentData;
import com.github.filipmalczak.inwent.impl.content.ContentRepository;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URL;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationController implements LocationAPI {


    @Autowired
    LocationRepository repository;

    @Autowired
    LocationConverter converter;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    ContentConverter contentConverter;

    @Autowired
    Values values;

    @Autowired
    Issues issues;

    @Autowired
    R2dbcEntityTemplate template;

    @Override
    public Mono<LocationDescriptor> getLocationById(URL id, boolean embedContent) {
        return repository
            .findByUrl(id.toString())
            .flatMap(d -> converter.convert(d, embedContent))
            .switchIfEmpty(issues.missingLocation(id));
    }

    @Override
    public Mono<ResponseEntity<LocationDescriptor>> createLocation(String host, CreateLocationRequest body) {
        return repository
            .existsByUrl(body.id().toString())
            .flatMap(exists -> exists ?
                issues.locationConflict(body.id()) :
                save(body).map(d -> ResponseEntity.ok(d))
            );
    }

    @Override
    public Mono<ResponseEntity<LocationDescriptor>> makeLocation(String host, CreateLocationRequest body) {
        return repository
            .existsByUrl(body.id().toString())
            .flatMap(exists ->
                save(body)
                    .map( desc ->
                        exists ?
                            ResponseEntity.ok(desc) :
                            ResponseEntity.created(
                                    values.uri(
                                        values.endpoint(
                                            host,
                                            "/location?id="+desc.id().toString()
                                        )
                                    )
                                )
                                .body(desc)
                    )
            );
    }


    @SneakyThrows
    private Mono<LocationDescriptor> save(CreateLocationRequest body){
        if (body.content() != null && body.contentId() != null)
            return issues.badRequest();

        return saveAssumingContracts(body)
            .flatMap(data ->
                converter.convert(data, false)
            );
    }

    @SneakyThrows
    private Mono<LocationData> saveAssumingContracts(CreateLocationRequest body){
        if (body.content() != null) {
            return contentRepository.save(
                    new ContentData(
                        null,
                        body.id().toURI().toString(),
                        body.content().title(),
                        body.content().type()
                    )
                )
                .flatMap(contentData ->
                    repository.save(
                        new LocationData(
                            null,
                            body.id().toString(),
                            body.type(),
                            contentData.uri()
                        )
                    )
                );
        }

        return repository.save(
            new LocationData(
                null,
                body.id().toString(),
                body.type(),
                body.contentId().toString()
            )
        );
    }
}
