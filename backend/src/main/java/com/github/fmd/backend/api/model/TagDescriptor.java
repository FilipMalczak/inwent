package com.github.fmd.backend.api.model;

import java.util.UUID;

public record TagDescriptor(
    UUID id,
    String name,
    UUID parent
) {
}
