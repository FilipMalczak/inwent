package com.github.fmd.backend.api;

import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.valid4j.Assertive.require;

public class APIUtils {


    public static <T> Mono<T> exactlyOne(Mono<T> mono){
        return mono.switchIfEmpty(Mono.error(Exceptions.ReactiveStreamException::new));
    }
}
