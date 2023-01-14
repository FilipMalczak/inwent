package com.github.filipmalczak.inwent.impl.location;

import com.github.filipmalczak.inwent.api.model.domain.location.LocationDescriptor;
import com.github.filipmalczak.inwent.impl.common.Values;
import com.github.filipmalczak.inwent.impl.content.ContentConverter;
import com.github.filipmalczak.inwent.impl.content.ContentRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class LocationConverter {
    @Autowired
    Values values;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    ContentConverter contentConverter;

    public Mono<LocationData> convert(LocationDescriptor descriptor){
        return just(
            new LocationData(
                null,
                descriptor.id().toString(),
                descriptor.type(),
                descriptor.contentId().toString()
            )
        );
    }

    public Mono<LocationDescriptor> convert(LocationData data, boolean embedContent){
        if (embedContent) {
            return contentRepository
                .findByUri(data.contentId())
                .flatMap(contentConverter::convert)
                .map(contentDescriptor ->
                    new LocationDescriptor(
                        values.url(data.url()),
                        data.type(),
                        null,
                        contentDescriptor
                    )
                );
        }
        return just(
            new LocationDescriptor(
                values.url(data.url()),
                data.type(),
                values.uri(data.contentId()),
                null
            )
        );
    }
}
