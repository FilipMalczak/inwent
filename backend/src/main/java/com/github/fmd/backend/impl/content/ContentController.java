package com.github.fmd.backend.impl.content;

import com.github.fmd.backend.api.ContentAPI;
import com.github.fmd.backend.api.model.ContentDescriptor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class ContentController implements ContentAPI{
    @Override
    public Mono<ContentDescriptor> getContent(URI uri) {
        return Mono.empty();
    }

    @Override
    public Mono<ContentDescriptor> putTags(URI uri, List<String> tagNames, List<UUID> tagIds) {
        return Mono.empty();
    }
}
