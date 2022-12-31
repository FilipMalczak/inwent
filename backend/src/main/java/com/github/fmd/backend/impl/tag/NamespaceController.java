package com.github.fmd.backend.impl.tag;

import com.github.fmd.backend.api.domain.NamespaceAPI;
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
public class NamespaceController implements NamespaceAPI {
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
}
