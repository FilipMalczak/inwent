package com.github.filipmalczak.inwent.impl.origin;

import com.github.filipmalczak.inwent.api.domain.OriginAPI;
import com.github.filipmalczak.inwent.api.model.domain.origin.NameWrapper;
import com.github.filipmalczak.inwent.api.model.domain.origin.OriginDescriptor;
import com.github.filipmalczak.inwent.impl.common.Issues;
import com.github.filipmalczak.inwent.impl.common.Values;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class OriginController implements OriginAPI {
    @Autowired
    OriginRepository repository;

    @Autowired
    OriginConverter converter;

    @Autowired
    Values values;

    @Autowired
    Issues issues;

    @Override
    public Mono<ResponseEntity<OriginDescriptor>> makOrigin(String hostname, NameWrapper body) {
        return repository
            .findByName(body.name())
            .map(x -> Pair.of(true, x))
            .switchIfEmpty(
                converter.convert(body).flatMap(repository::save).map(x -> Pair.of(false, x))
            )
            .flatMap(pair -> converter.convert(pair.getSecond()).map(desc -> Pair.of(pair.getFirst(), desc)))
            .map(pair ->
                pair.getFirst() ?
                    ResponseEntity.ok(pair.getSecond()) :
                    ResponseEntity.created(
                            values.uri(
                                values.endpoint(
                                    hostname,
                                    "/origin/"+pair.getSecond().id().toString()
                                )
                            )
                        )
                        .body(pair.getSecond())
            );
    }

    @Override
    public Mono<OriginDescriptor> getOriginById(UUID id) {
        return repository
            .findById(id)
            .flatMap(converter::convert)
            .switchIfEmpty(issues.missingOrigin("id", id.toString()));
    }

    @Override
    public Mono<OriginDescriptor> getOriginByName(String name) {
        return repository
            .findByName(name)
            .flatMap(converter::convert)
            .switchIfEmpty(issues.missingOrigin("name", name));
    }
}
