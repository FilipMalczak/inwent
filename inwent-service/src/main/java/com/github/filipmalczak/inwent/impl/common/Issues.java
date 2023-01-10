package com.github.filipmalczak.inwent.impl.common;

import com.github.filipmalczak.inwent.api.model.domain.tag.NamespaceDescriptor;
import com.github.filipmalczak.inwent.impl.common.exceptions.AlreadyExistsException;
import com.github.filipmalczak.inwent.impl.common.exceptions.MissingException;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.net.URL;
import java.util.UUID;

import static java.util.Arrays.asList;

@Component
public class Issues {

    //todo add handlers
    public <T> Mono<T> missingContent(URI id){
        return Mono.error(new MissingException("content", "id", asList(id.toString())));
    }

    public <T> Mono<T> missingLocation(URL id){
        return Mono.error(new MissingException("location", "id", asList(id.toString())));
    }

    public <T> Mono<T> missingOrigin(String searchTerm, String searchValue){
        return Mono.error(new MissingException("origin", searchTerm, asList(searchValue)));
    }

    public <T> Mono<T> missingNamespace(String idOrPath) {
        return Mono.error(new MissingException("namespace", "id_or_path", asList(idOrPath)));
    }

    public <T> Mono<T> missingTag(String idOrPath, String tagName) {
        return Mono.error(new MissingException("tag", "namespace_slash_name", asList(idOrPath+"/"+tagName)));
    }

    public <T> Mono<T> locationConflict(URL url){
        return Mono.error(new AlreadyExistsException("location", "id", url.toString()));
    }

    public <T> Mono<T> badRequest() {
        return Mono.error(new ResponseStatusException(HttpStatusCode.valueOf(400)));
    }
}
