package com.github.fmd.backend.api.model.domain.hit;

import java.util.UUID;

public record TagHits(
    UUID id,
    String name,
    int hits
) {
}
