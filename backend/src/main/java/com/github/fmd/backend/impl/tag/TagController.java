package com.github.fmd.backend.impl.tag;

import com.github.fmd.backend.api.TagAPI;
import com.github.fmd.backend.api.model.TagDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class TagController implements TagAPI {

    @Override
    public Mono<ResponseEntity<TagDescriptor>> makeTagByName(String namespaceId, String tagName) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<TagDescriptor>> getTagByName(String namespaceId, String tagName) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<TagDescriptor>> getTagById(UUID id) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> bindParent(UUID childId, UUID parentId) {
        return null;
    }

    @Override
    public Mono<ResponseEntity<Void>> unbindParent(UUID childId) {
        return null;
    }
}
