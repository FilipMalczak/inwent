package com.github.filipmalczak.inwent.impl.tag;

import com.github.filipmalczak.inwent.api.domain.TagAPI;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagAndNamespaceDescriptors;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagController implements TagAPI {
    @Autowired
    TagRepository repository;

    @Autowired
    TagConverter converter;

    @Override
    public Mono<TagDescriptor> getTagById(UUID id) {
        return repository
            .findById(id)
            .flatMap(converter::convert);
    }

    @Override
    public Mono<TagAndNamespaceDescriptors> getTagWithDetailsById(UUID id) {
        return repository
            .findById(id)
            .flatMap(converter::convertWitDetails);
    }
}
