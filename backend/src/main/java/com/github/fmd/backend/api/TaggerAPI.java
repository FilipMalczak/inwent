package com.github.fmd.backend.api;

import com.github.fmd.backend.api.model.NameWrapper;
import com.github.fmd.backend.api.model.NamespaceDescriptor;
import com.github.fmd.backend.api.model.TaggerDescriptor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Tag(name = "Taggers management")
@SecurityRequirement(name = "accessToken")
@RequestMapping("/api/v${api.version}")
public interface TaggerAPI {
    @PostMapping("/tagger")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Created", responseCode = "201")
    })
    Mono<ResponseEntity<TaggerDescriptor>> makeTagger(@Parameter(hidden = true) @RequestHeader("Host") String hostname, @RequestBody NameWrapper body);

    @GetMapping("/tagger/{id}")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<TaggerDescriptor> getTaggerById(@PathVariable UUID id);

    @GetMapping("/tagger")
    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200"),
        @ApiResponse(description = "Not found", responseCode = "404", content = @Content())
    })
    Mono<TaggerDescriptor> getTaggerByName(@RequestParam String name);
}
