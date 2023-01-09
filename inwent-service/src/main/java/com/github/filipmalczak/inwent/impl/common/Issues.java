package com.github.filipmalczak.inwent.impl.common;

import com.github.filipmalczak.inwent.api.model.domain.location.LocationDescriptor;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URL;

@Component
public class Issues {

    //todo add handlers
    public <T> Mono<T> missingContent(URI id){
        return Mono.error(new MissingException("content", "content", id.toString()));
    }

    public <T> Mono<T> missingLocation(URL id){
        return Mono.error(new MissingException("location", "locations", id.toString()));
    }

    public <T> Mono<T> locationConflict(URL url){
        return Mono.error(new AlreadyExistsException("location", url.toString()));
    }

    public <T> Mono<T> badRequest() {
        return Mono.error(new ResponseStatusException(HttpStatusCode.valueOf(400)));
    }
}
