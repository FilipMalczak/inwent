package com.github.fmd.backend.api;

import com.github.fmd.backend.api.model.AccessTokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Tag(name = "Access token management")
@SecurityRequirement(name = "adminSecret")
@RequestMapping("/api/v${api.version}")
public interface AdminAPI {
    @PostMapping("/accesstoken/{name}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Created", responseCode = "201"),
        @ApiResponse(description = "Bad request (token name format error)", responseCode = "400", content = @Content())
    })
    Mono<AccessTokenResponse> makeToken(@PathVariable String name);

    @DeleteMapping("/accesstoken/{name}")
    @Operation(responses = {
        @ApiResponse(description = "No Content", responseCode = "204"),
        @ApiResponse(description = "Bad request (token name format error)", responseCode = "400", content = @Content()),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<Void> revokeToken(@PathVariable String name);
}
