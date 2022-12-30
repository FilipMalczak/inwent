package com.github.fmd.backend.api;

import com.github.fmd.backend.api.model.NamespaceDescriptor;
import com.github.fmd.backend.api.model.TagAndNamespaceDescriptors;
import com.github.fmd.backend.api.model.TagDescriptor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Tag(name = "Tag and namespace management")
@SecurityRequirement(name = "accessToken")
@RequestMapping("/api/v${api.version}")
public interface TagAPI {

    ////////////////////////////////////
    //
    // NAMESPACE
    // CR; C=upsert, R=one
    //
    ////////////////////////////////////

    @PostMapping("/namespace/{path}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Created", responseCode = "201"),
        @ApiResponse(description = "Bad request (path format error)", responseCode = "400", content = @Content())
    })
    Mono<ResponseEntity<NamespaceDescriptor>> makeNamespace(@Parameter(hidden = true) @RequestHeader("Host") String hostname, @PathVariable String path);

    @GetMapping("/namespace/{pathOrId}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Bad request (path format error)", responseCode = "400", content = @Content()),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<NamespaceDescriptor> getNamespace(@PathVariable String pathOrId);


    ////////////////////////////////////
    //
    // TAGS IN NAMESPACE
    // CR, C=upsert, R=one by name,all in namespace
    //
    ////////////////////////////////////

    @PostMapping("/namespace/{namespaceId}/tag/{tagName}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Created", responseCode = "201"),
        @ApiResponse(description = "Bad request (tag name format error)", responseCode = "400", content = @Content())
    })
    Mono<ResponseEntity<TagDescriptor>> makeTagByName(@Parameter(hidden = true) @RequestHeader("Host") String hostname,
                                                      @PathVariable String namespaceId, @PathVariable String tagName);

    @GetMapping("/namespace/{id}/tag")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Flux<TagDescriptor> getTagsByNamespace(@PathVariable String id);

    @GetMapping("/namespace/{namespaceId}/tag/{tagName}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Bad request (tag name format error)", responseCode = "400", content = @Content()),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<TagDescriptor> getTagByName(@PathVariable String namespaceId, @PathVariable String tagName);

    ////////////////////////////////////
    //
    // TAGS, GLOBALLY
    // R=one by id
    //
    ////////////////////////////////////

    @GetMapping("/tag/{id}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<TagDescriptor> getTagById(@PathVariable UUID id);

    @GetMapping("/tag/{id}/details")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<TagAndNamespaceDescriptors> getTagWithDetailsById(@PathVariable UUID id);

    ////////////////////////////////////
    //
    // PARENT-CHILD
    // CR, C=insert, upsert, R=downstream aka all children
    //
    // # to read parent, just look up the tag descriptor by namespace+name or by id
    ////////////////////////////////////

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
