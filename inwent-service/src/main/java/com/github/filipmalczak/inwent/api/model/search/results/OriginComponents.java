package com.github.filipmalczak.inwent.api.model.search.results;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record OriginComponents(
    @Schema(nullable = true) UUID id,
    @Schema(nullable = true) String name,
    @Schema(nullable = true) Integer totalHitCount
) {
}
