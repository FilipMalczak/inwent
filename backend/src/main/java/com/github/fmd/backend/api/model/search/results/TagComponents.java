package com.github.fmd.backend.api.model.search.results;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record TagComponents(
    @Schema(nullable = true) UUID id,
    @Schema(nullable = true) String name,
    @Schema(nullable = true) String namespace,
    @Schema(nullable = true) String path,
    @Schema(nullable = true) UUID parentId,
    @Schema(nullable = true) UUID parentName,
    @Schema(nullable = true) UUID parentPath
) {
}
