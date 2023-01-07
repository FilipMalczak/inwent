package com.github.filipmalczak.inwent.api.model.search.results;

public record HitResult(
    ContentComponents content,
    OriginComponents origin,
    TagComponents tag
) {
}
