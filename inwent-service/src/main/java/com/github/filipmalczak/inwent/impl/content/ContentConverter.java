package com.github.filipmalczak.inwent.impl.content;

import com.github.filipmalczak.inwent.api.model.domain.content.ContentDescriptor;
import com.github.filipmalczak.inwent.impl.common.Values;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static reactor.core.publisher.Mono.just;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContentConverter {
    @Autowired
    Values values;

    public Mono<ContentDescriptor> convert(ContentData data){
        return just(
            new ContentDescriptor(
                values.uri(data.uri()),
                data.title(),
                data.type()
            )
        );
    }

    public Mono<ContentData> convert(ContentDescriptor descriptor){
        return just(
            new ContentData(
                null,
                descriptor.uri().toString(),
                descriptor.title(),
                descriptor.type()
            )
        );
    }

}
