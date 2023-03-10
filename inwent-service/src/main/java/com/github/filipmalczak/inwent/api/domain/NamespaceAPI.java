package com.github.filipmalczak.inwent.api.domain;

import com.github.filipmalczak.inwent.api.model.domain.tag.NamespaceDescriptor;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import com.github.filipmalczak.inwent.api.security.Stability;
import com.github.filipmalczak.inwent.api.security.annotations.AccessToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Tag(name = "Namespace management and tag scoping", description = Stability.STABLE)
@AccessToken
@RequestMapping("/api/v${api.version}")
public interface NamespaceAPI {

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

    @GetMapping("/namespace/{idOrPath}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Bad request (path format error)", responseCode = "400", content = @Content()),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<NamespaceDescriptor> getNamespace(@PathVariable String idOrPath);


    ////////////////////////////////////
    //
    // TAGS IN NAMESPACE
    // CR, C=upsert, R=one by name,all in namespace
    //
    ////////////////////////////////////

    @PostMapping("/namespace/{idOrPath}/tag/{tagName}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Created", responseCode = "201"),
        @ApiResponse(description = "Bad request (tag name format error)", responseCode = "400", content = @Content())
    })
    Mono<ResponseEntity<TagDescriptor>> makeTagByName(@Parameter(hidden = true) @RequestHeader("Host") String hostname,
                                                      @PathVariable String idOrPath, @PathVariable String tagName);

    @GetMapping("/namespace/{idOrPath}/tag")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Flux<TagDescriptor> getTagsByNamespace(@PathVariable String idOrPath);

    @GetMapping("/namespace/{idOrPath}/tag/{tagName}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Bad request (tag name format error)", responseCode = "400", content = @Content()),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<TagDescriptor> getTagByName(@PathVariable String idOrPath, @PathVariable String tagName);
}
