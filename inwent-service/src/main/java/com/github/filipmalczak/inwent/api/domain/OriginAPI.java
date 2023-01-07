package com.github.filipmalczak.inwent.api.domain;

import com.github.filipmalczak.inwent.api.model.domain.origin.NameWrapper;
import com.github.filipmalczak.inwent.api.model.domain.origin.OriginDescriptor;
import com.github.filipmalczak.inwent.api.security.Stability;
import com.github.filipmalczak.inwent.api.security.annotations.AccessToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Tag(name = "Origin management", description = Stability.STABLE)
@AccessToken
@RequestMapping("/api/v${api.version}")
public interface OriginAPI {
    @PostMapping("/origin")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Created", responseCode = "201")
    })
    Mono<ResponseEntity<OriginDescriptor>> makOrigin(@Parameter(hidden = true) @RequestHeader("Host") String hostname, @RequestBody NameWrapper body);

    @GetMapping("/origin/{id}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<OriginDescriptor> getOriginById(@PathVariable UUID id);

    @GetMapping("/origin")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<OriginDescriptor> getOriginByName(@RequestParam String name);
}
