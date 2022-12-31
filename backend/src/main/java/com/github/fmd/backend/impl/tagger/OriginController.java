package com.github.fmd.backend.impl.tagger;

import com.github.fmd.backend.api.domain.OriginAPI;
import com.github.fmd.backend.api.model.NameWrapper;
import com.github.fmd.backend.api.model.OriginDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class OriginController implements OriginAPI {
    @Override
    public Mono<ResponseEntity<OriginDescriptor>> makOrigin(String hostname, NameWrapper body) {
        return null;
    }

    @Override
    public Mono<OriginDescriptor> getOriginById(UUID id) {
        return null;
    }

    @Override
    public Mono<OriginDescriptor> getOriginByName(String name) {
        return null;
    }
}
