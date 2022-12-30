package com.github.fmd.backend.impl.tagger;

import com.github.fmd.backend.api.domain.TaggerAPI;
import com.github.fmd.backend.api.model.NameWrapper;
import com.github.fmd.backend.api.model.TaggerDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class TaggerController implements TaggerAPI {
    @Override
    public Mono<ResponseEntity<TaggerDescriptor>> makeTagger(String hostname, NameWrapper body) {
        return null;
    }

    @Override
    public Mono<TaggerDescriptor> getTaggerById(UUID id) {
        return null;
    }

    @Override
    public Mono<TaggerDescriptor> getTaggerByName(String name) {
        return null;
    }
}
