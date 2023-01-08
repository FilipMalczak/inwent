package com.github.filipmalczak.inwent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RestController
public class FooController {
    @Autowired
    private FooRepo repo;

    @PostMapping("/api/x/foo/{name}")
    public Mono<Void> make(@PathVariable String name){
        return repo.save(new Foo(null, name)).then();
    }

    @GetMapping("/api/x/foo/{name}")
    public Mono<FooView> get(@PathVariable String name){
        return repo.findByName(name).map(d -> new FooView(name, System.currentTimeMillis())).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatusCode.valueOf(404))));
    }
}
