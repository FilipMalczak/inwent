package com.github.fmd.backend.api.model;

import java.util.UUID;

public record OriginDescriptor(
    UUID id,
    String name
) {
}
