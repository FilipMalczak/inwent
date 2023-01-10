package com.github.filipmalczak.inwent.impl.tag;

import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Component
public class TagConverter {
    public Mono<TagDescriptor> convert(TagData data){
        return just(
            new TagDescriptor(
                data.id(),
                data.name(),
                data.parentId()
            )
        );
    }
}
