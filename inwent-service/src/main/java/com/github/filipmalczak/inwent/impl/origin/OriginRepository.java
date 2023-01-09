package com.github.filipmalczak.inwent.impl.origin;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface OriginRepository extends R2dbcRepository<OriginData, UUID> {
    Mono<Boolean> existsByName(String name);
    Mono<OriginData> findByName(String name);
}
