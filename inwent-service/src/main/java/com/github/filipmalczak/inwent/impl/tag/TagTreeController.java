package com.github.filipmalczak.inwent.impl.tag;

import com.github.filipmalczak.inwent.api.domain.TagTreeAPI;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class TagTreeController implements TagTreeAPI {
    @Override
    public Mono<Void> bindParent(UUID childId, UUID parentId) {
        return null;
    }

    @Override
    public Mono<Void> bindOrRebindParent(UUID childId, UUID parentId) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> unbindParent(UUID childId) {
        return null;
    }

    @Override
    public Flux<UUID> getTagChildren(UUID parentId) {
        return null;
    }

    @Override
    public Flux<TagDescriptor> getTagChildrenDescriptions(UUID parentId) {
        return null;
    }
}
