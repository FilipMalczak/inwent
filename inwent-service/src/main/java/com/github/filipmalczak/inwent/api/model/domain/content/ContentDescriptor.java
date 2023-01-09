package com.github.filipmalczak.inwent.api.model.domain.content;

import com.github.filipmalczak.inwent.api.model.domain.hit.TagHits;

import java.net.URI;
import java.util.List;

public record ContentDescriptor(
    URI uri,
    String title,
    String type
) {
}
