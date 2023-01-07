package com.github.filipmalczak.inwent.api.domain;

import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import com.github.filipmalczak.inwent.api.security.Stability;
import com.github.filipmalczak.inwent.api.security.annotations.AccessToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Tag(name = "Tag hierarchy management", description = Stability.STABLE)
@AccessToken
@RequestMapping("/api/v${api.version}")
public interface TagTreeAPI {
    @PutMapping("/tag/{childId}/parent/{parentId}")
    @Operation(responses = {
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Bad request (tags belong to different namespaces)", responseCode = "400", content = @Content()),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content()),
        @ApiResponse(description = "Conflict (parent was already set)", responseCode = "409", content = @Content())
    })
    Mono<Void> bindParent(@PathVariable UUID childId, @PathVariable UUID parentId);

    @PostMapping("/tag/{childId}/parent/{parentId}")
    @Operation(responses = {
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Bad request (tags belong to different namespaces)", responseCode = "400", content = @Content()),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content()),
    })
    Mono<Void> bindOrRebindParent(@PathVariable UUID childId, @PathVariable UUID parentId);

    @DeleteMapping("/tag/{childId}/parent")
    @Operation(responses = {
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Bad request (child has no parent to unbind)", responseCode = "400", content = @Content()),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<ResponseEntity<Void>> unbindParent(@PathVariable UUID childId);

    @GetMapping("/tag/{parentId}/children")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Flux<UUID> getTagChildren(@PathVariable UUID parentId);

    @GetMapping("/tag/{parentId}/children/description")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Flux<TagDescriptor> getTagChildrenDescriptions(@PathVariable UUID parentId);
}
