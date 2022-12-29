package com.github.fmd.backend.api.model;

import java.util.UUID;

public record TagHits(
    UUID id,
    String name,
    int hits
) {
}
