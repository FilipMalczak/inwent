package com.github.filipmalczak.inwent.impl.tag;

import com.github.filipmalczak.inwent.api.model.domain.tag.NamespaceDescriptor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Component
public class NamespaceConverter {
    public Mono<NamespaceDescriptor> convert(NamespaceData data){
        return just(
            new NamespaceDescriptor(
                data.id(),
                data.path()
            )
        );
    }
}
