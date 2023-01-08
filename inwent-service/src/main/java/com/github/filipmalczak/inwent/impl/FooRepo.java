package com.github.filipmalczak.inwent.impl;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface FooRepo extends R2dbcRepository<Foo, String> {
    Mono<Foo> findByName(String name);
}
