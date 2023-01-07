package com.github.filipmalczak.inwent.api.model.domain.hit;

import java.util.UUID;

public record TagHits(
    UUID id,
    String name,
    int hits
) {
}
