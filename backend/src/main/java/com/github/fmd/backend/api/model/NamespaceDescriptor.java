package com.github.fmd.backend.api.model;

import java.util.UUID;

public record NamespaceDescriptor(
    UUID id,
    String path
) {
}
