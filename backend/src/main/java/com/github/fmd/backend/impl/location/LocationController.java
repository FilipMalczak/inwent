package com.github.fmd.backend.impl.location;

import com.github.fmd.backend.api.domain.LocationAPI;
import com.github.fmd.backend.api.model.CreateLocationRequest;
import com.github.fmd.backend.api.model.LocationDescriptor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URL;

@RestController
public class LocationController implements LocationAPI {
    @Override
    public Mono<LocationDescriptor> getLocationById(URL id, boolean embedContent) {
        return null;
    }

    @Override
    public Mono<LocationDescriptor> createLocation(String host, CreateLocationRequest body) {
        return null;
    }

    @Override
    public Mono<LocationDescriptor> makeLocation(String host, CreateLocationRequest body) {
        return null;
    }
}
