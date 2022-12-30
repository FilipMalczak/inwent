
package com.github.fmd.backend.api;

import com.github.fmd.backend.api.model.ContentDescriptor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static com.github.fmd.backend.api.APIUtils.*;
import static java.util.Optional.ofNullable;
import static org.valid4j.Assertive.require;

@Tag(name = "Content inspection and tagging")
@SecurityRequirement(name = "accessToken")
@RequestMapping("/api/v${api.version}")
public interface ContentAPI {
    //todo cleanup this mess
    @GetMapping("/content")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    @SneakyThrows
    default Mono<ContentDescriptor> getContentById(@RequestParam URI id){
        return exactlyOne(getContent(id));
    }

    @PutMapping("/content/tag")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Bad request (when no tags are specified)", responseCode = "400", content = @Content())
    })
    @SneakyThrows
    default Mono<ContentDescriptor> putTagsOnContent(
        @RequestParam("content-id") URI contentId,
        @RequestParam(value = "tag-name", required = false) List<String> tagNames,
        @RequestParam(value = "tag-id", required = false) List<UUID> tagIds,
        @RequestHeader(value = "X-Inwent-Tagger-Id") UUID taggerId
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

    //todo delete tag; rephrase to "add/remove hit"

    Mono<ContentDescriptor> getContent(URI uri);

    Mono<ContentDescriptor> putTags(URI uri, List<String> tagNames, List<UUID> tagIds);


}
