package com.github.filipmalczak.inwent.api.model.search.results;

import io.swagger.v3.oas.annotations.media.Schema;

import java.net.URI;
import java.net.URL;
import java.util.List;

public record ContentComponents(
    @Schema(nullable = true) URI id,
    @Schema(nullable = true) List<URL> locations,
    @Schema(nullable = true) Integer locationCount,
    @Schema(nullable = true) Integer tagCount,
    @Schema(nullable = true) Integer totalHitCount
) {
}
