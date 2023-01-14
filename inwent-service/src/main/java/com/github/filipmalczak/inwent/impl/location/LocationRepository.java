package com.github.filipmalczak.inwent.impl.location;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface LocationRepository extends R2dbcRepository<LocationData, Long> {
    Mono<Boolean> existsByUrl(String url);
    Mono<LocationData> findByUrl(String url);
}
