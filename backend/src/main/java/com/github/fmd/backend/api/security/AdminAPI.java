package com.github.fmd.backend.api.security;

import com.github.fmd.backend.api.model.AccessTokenResponse;
import com.github.fmd.backend.api.security.annotations.AdminSecret;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Tag(name = "Access token management", description = Stability.STABLE)
@AdminSecret
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

    public static Components addSecurity(Components components){
        return components
            .addSecuritySchemes("adminSecret",
                new SecurityScheme()
                    .type(SecurityScheme.Type.APIKEY)
                    .in(SecurityScheme.In.HEADER)
                    .name("X-Inwent-Admin-Secret")
            )
            .addSecuritySchemes("accessToken",
                new SecurityScheme()
                    .type(SecurityScheme.Type.APIKEY)
                    .in(SecurityScheme.In.HEADER)
                    .name("X-Inwent-Access-Token")
            )
            .addResponses(
                "AdminUnauthorized",
                new io.swagger.v3.oas.models.responses.ApiResponse()
                    .description("Unauthorized (Admin Secret is missing)")
            )
            .addResponses(
                "UserUnauthorized",
                new io.swagger.v3.oas.models.responses.ApiResponse()
                    .description("Unauthorized (Access Token is missing)")
            );
    }
}
