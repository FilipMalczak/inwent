package com.github.filipmalczak.inwent.impl.tag;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface TagRepository extends R2dbcRepository<TagData, UUID> {
    Mono<TagData> findByNamespaceIdAndName(UUID namespaceId, String name);

    Flux<TagData> findAllByNamespaceId(UUID namespaceId);
}
