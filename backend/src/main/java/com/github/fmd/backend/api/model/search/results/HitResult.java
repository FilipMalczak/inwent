package com.github.fmd.backend.api.model.search.results;

public record HitResult(
    ContentComponents content,
    OriginComponents origin,
    TagComponents tag
) {
}
