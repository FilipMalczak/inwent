package com.github.filipmalczak.inwent.api.model.domain.tag;

import java.util.UUID;

public record NamespaceDescriptor(
    UUID id,
    String path
) {
}
