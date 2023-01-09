package com.github.filipmalczak.inwent.impl.content;

import com.github.filipmalczak.inwent.impl.location.LocationData;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ContentRepository extends ReactiveCrudRepository<ContentData, Long> {
    Mono<Boolean> existsByUri(String uri);
    Mono<ContentData> findByUri(String uri);
}
