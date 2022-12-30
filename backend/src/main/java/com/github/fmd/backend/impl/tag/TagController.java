package com.github.fmd.backend.impl.tag;

import com.github.fmd.backend.api.domain.TagAPI;
import com.github.fmd.backend.api.model.NamespaceDescriptor;
import com.github.fmd.backend.api.model.TagAndNamespaceDescriptors;
import com.github.fmd.backend.api.model.TagDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class TagController implements TagAPI {

    @Override
    public Mono<ResponseEntity<NamespaceDescriptor>> makeNamespace(String hostname, String path) {
        return null;
    }

    @Override
    public Mono<NamespaceDescriptor> getNamespace(String pathOrId) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<TagDescriptor>> makeTagByName(String hostname, String namespaceId, String tagName) {
        return null;
    }

    @Override
    public Flux<TagDescriptor> getTagsByNamespace(String id) {
        return null;
    }

    @Override
    public Mono<TagDescriptor> getTagByName(String namespaceId, String tagName) {
        return null;
    }

    @Override
    public Mono<TagDescriptor> getTagById(UUID id) {
        return null;
    }

    @Override
    public Mono<TagAndNamespaceDescriptors> getTagWithDetailsById(UUID id) {
        return null;
    }

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
        return Flux.range(0, 10).map(x -> UUID.randomUUID());
    }

    @Override
    public Flux<TagDescriptor> getTagChildrenDescriptions(UUID parentId) {
        return null;
    }
}
