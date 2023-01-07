package com.github.filipmalczak.inwent.api.model.domain.location;

import com.github.filipmalczak.inwent.api.model.domain.content.ContentDescriptor;

import java.net.URI;
import java.net.URL;

public record LocationDescriptor(
    URL id,
    String type,
    URI contentId,
    ContentDescriptor content
) {
}
