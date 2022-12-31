
package com.github.fmd.backend.api.domain;

import com.github.fmd.backend.api.model.ContentDescriptor;
import com.github.fmd.backend.api.security.Stability;
import com.github.fmd.backend.api.security.annotations.AccessToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Tag(name = "Content inspection and tagging", description = Stability.STABLE)
@AccessToken
@RequestMapping("/api/v${api.version}")
public interface ContentAPI {
    @GetMapping("/content")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<ContentDescriptor> getContentById(@RequestParam URI id);

    @PutMapping("/content/tag")
    @Operation(description = Stability.EVOLVING, responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Bad request (when no tags are specified)", responseCode = "400", content = @Content())
    })
    @SneakyThrows
    default Mono<ContentDescriptor> putTagsOnContent(
        @RequestParam("content-id") URI contentId,
        @RequestParam(value = "tag-name", required = false) List<String> tagNames,
        @RequestParam(value = "tag-id", required = false) List<UUID> tagIds,
        @RequestHeader(value = "X-Inwent-Origin-Id") UUID taggerId
        ){
        //this is an allowed case for default method in API interface -
        if (tagNames.size()+tagIds.size() == 0)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST); //DO NOT add any details; let consumers learn to read the docs
        return putTags(
            contentId,
            tagNames,
            tagIds
        );
    }

    //todo delete tag; rephrase to "add/remove hit"

    Mono<ContentDescriptor> putTags(URI uri, List<String> tagNames, List<UUID> tagIds);


}
