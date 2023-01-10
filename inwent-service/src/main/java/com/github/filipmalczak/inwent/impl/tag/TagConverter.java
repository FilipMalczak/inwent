package com.github.filipmalczak.inwent.impl.tag;

import com.github.filipmalczak.inwent.api.model.domain.tag.TagAndNamespaceDescriptors;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagConverter {
    @Autowired
    NamespaceRepository namespaceRepository;

    @Autowired
    NamespaceConverter namespaceConverter;

    public Mono<TagDescriptor> convert(TagData data){
        return just(
            new TagDescriptor(
                data.id(),
                data.name(),
                data.parentId()
            )
        );
    }

    public Mono<TagAndNamespaceDescriptors> convertWitDetails(TagData data){
        return namespaceRepository
            .findById(data.id())
            .flatMap(namespaceConverter::convert)
            .map( nmsp ->
                new TagAndNamespaceDescriptors(
                    new TagDescriptor(
                        data.id(),
                        data.name(),
                        data.parentId()
                    ),
                    nmsp
                )
            );
    }
}
