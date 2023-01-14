package com.github.filipmalczak.inwent.impl.content;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ContentRepository extends R2dbcRepository<ContentData, Long> {
    Mono<Boolean> existsByUri(String uri);
    Mono<ContentData> findByUri(String uri);
}
