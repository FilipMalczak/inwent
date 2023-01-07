package com.github.filipmalczak.inwent.api.model.domain.tag;

import java.util.UUID;

public record TagDescriptor(
    UUID id,
    String name,
    UUID parent
) {
}
