package com.github.fmd.backend.api.model.domain.origin;

import java.util.UUID;

public record OriginDescriptor(
    UUID id,
    String name
) {
}
