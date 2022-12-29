
package com.github.fmd.backend.api;

import com.github.fmd.backend.api.model.ContentDescriptor;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static com.github.fmd.backend.api.APIUtils.*;
import static java.util.Optional.ofNullable;
import static org.valid4j.Assertive.require;

@Tag(name = "Content inspection and tagging")
@RequestMapping("/api/v${api.version}")
public interface ContentAPI {
    @GetMapping("/content")
    @SneakyThrows
    default Mono<ContentDescriptor> getContentById(@RequestParam URI id){
        return exactlyOne(getContent(id));
    }

    @PutMapping("/content/tag")
    @SneakyThrows
    default Mono<ContentDescriptor> putTagsOnContent(
        @RequestParam("content-id") URI contentId,
        @RequestParam(value = "tag-name", required = false) List<String> tagNames,
        @RequestParam(value = "tag-id", required = false) List<UUID> tagIds
        ){
        require(tagNames.size()+tagIds.size() > 0);
        return exactlyOne(
            putTags(
                contentId,
                tagNames,
                tagIds
            )
        );
    }

    Mono<ContentDescriptor> getContent(URI uri);

    Mono<ContentDescriptor> putTags(URI uri, List<String> tagNames, List<UUID> tagIds);


}
