package com.github.filipmalczak.inwent.api.domain;

import com.github.filipmalczak.inwent.api.model.domain.tag.TagAndNamespaceDescriptors;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import com.github.filipmalczak.inwent.api.security.Stability;
import com.github.filipmalczak.inwent.api.security.annotations.AccessToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Tag(name = "Tag management", description = Stability.STABLE)
@AccessToken
@RequestMapping("/api/v${api.version}")
public interface TagAPI {
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



}
