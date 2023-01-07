package com.github.filipmalczak.inwent.impl.tag;

import com.github.filipmalczak.inwent.api.domain.TagAPI;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagAndNamespaceDescriptors;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class TagController implements TagAPI {
    @Override
    public Mono<TagDescriptor> getTagById(UUID id) {
        return null;
    }

    @Override
    public Mono<TagAndNamespaceDescriptors> getTagWithDetailsById(UUID id) {
        return null;
    }
}