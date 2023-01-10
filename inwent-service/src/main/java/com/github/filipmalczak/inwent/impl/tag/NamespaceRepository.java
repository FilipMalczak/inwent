package com.github.filipmalczak.inwent.impl.tag;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface NamespaceRepository extends R2dbcRepository<NamespaceData, UUID> {
    Mono<NamespaceData> findByPath(String path);
}
