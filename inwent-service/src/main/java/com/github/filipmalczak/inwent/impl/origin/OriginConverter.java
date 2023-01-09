package com.github.filipmalczak.inwent.impl.origin;

import com.github.filipmalczak.inwent.api.model.domain.origin.NameWrapper;
import com.github.filipmalczak.inwent.api.model.domain.origin.OriginDescriptor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class OriginConverter {
    public Mono<OriginData> convert(NameWrapper named){
        return just(
            new OriginData(
                null,
                named.name()
            )
        );
    }

    public Mono<OriginDescriptor> convert(OriginData data){
        return just(
            new OriginDescriptor(
                data.id(),
                data.name()
            )
        );
    }
}
