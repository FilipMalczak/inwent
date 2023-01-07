package com.github.filipmalczak.inwent.api.model.domain.origin;

import java.util.UUID;

public record OriginDescriptor(
    UUID id,
    String name
) {
}
