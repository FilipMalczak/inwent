package com.github.filipmalczak.inwent.api.model.domain.content;

import java.net.URI;

public record ContentDescriptor(
    URI uri,
    String title,
    String type
) {
}
