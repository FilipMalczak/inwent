package com.github.filipmalczak.inwent.impl.content;

import com.github.filipmalczak.inwent.api.domain.ContentAPI;
import com.github.filipmalczak.inwent.api.model.domain.content.ContentDescriptor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class ContentController implements ContentAPI{
    @Override
    public Mono<ContentDescriptor> getContentById(URI id) {
        return null;
    }

    @Override
    public Mono<ContentDescriptor> putTags(URI uri, List<String> tagNames, List<UUID> tagIds) {
        return Mono.empty();
    }
}
