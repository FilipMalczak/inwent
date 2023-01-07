package com.github.filipmalczak.inwent.impl.location;

import com.github.filipmalczak.inwent.api.domain.LocationAPI;
import com.github.filipmalczak.inwent.api.model.domain.location.CreateLocationRequest;
import com.github.filipmalczak.inwent.api.model.domain.location.LocationDescriptor;
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
