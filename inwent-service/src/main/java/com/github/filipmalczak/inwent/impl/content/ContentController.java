package com.github.filipmalczak.inwent.impl.content;

import com.github.filipmalczak.inwent.api.domain.ContentAPI;
import com.github.filipmalczak.inwent.api.model.domain.content.ContentDescriptor;
import com.github.filipmalczak.inwent.impl.common.Issues;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContentController implements ContentAPI{
    @Autowired
    ContentRepository repository;

    @Autowired
    ContentConverter converter;

    @Autowired
    Issues issues;

    @Override
    public Mono<ContentDescriptor> getContentById(URI id) {
        return repository
            .findByUri(id.toString())
            .flatMap(converter::convert)
            .switchIfEmpty(issues.missingContent(id));
    }
}
