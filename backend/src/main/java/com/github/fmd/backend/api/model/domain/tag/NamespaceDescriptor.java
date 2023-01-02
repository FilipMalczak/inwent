package com.github.fmd.backend.api.model.domain.tag;

import java.util.UUID;

public record NamespaceDescriptor(
    UUID id,
    String path
) {
}
