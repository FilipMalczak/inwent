package com.github.fmd.backend.api;

import com.github.fmd.backend.api.model.TagDescriptor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Tag(name = "Tag management")
@RequestMapping("/api/v${api.version}")
public interface TagAPI {

    @PostMapping("/namespace/{namespaceId}/tag/{tagName}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Created", responseCode = "201")
    })
    Mono<ResponseEntity<TagDescriptor>> makeTagByName(@PathVariable String namespaceId, @PathVariable String tagName);

    @GetMapping("/namespace/{namespaceId}/tag/{tagName}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404")
    })
    Mono<ResponseEntity<TagDescriptor>> getTagByName(@PathVariable String namespaceId, @PathVariable String tagName);

    @GetMapping("/tag/{id}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404")
    })
    Mono<ResponseEntity<TagDescriptor>> getTagById(@PathVariable UUID id);

    @PutMapping("/tag/{childId}/parent/{parentId}")
    @Operation(responses = {
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Bad request (tags belong to different namespaces)", responseCode = "400"),
        @ApiResponse(description = "Not found", responseCode = "404")
    })
    Mono<ResponseEntity<Void>> bindParent(@PathVariable UUID childId, @PathVariable UUID parentId);

    @DeleteMapping("/tag/{childId}/parent")
    @Operation(responses = {
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Not found", responseCode = "404")
    })
    Mono<ResponseEntity<Void>> unbindParent(@PathVariable UUID childId);
}
