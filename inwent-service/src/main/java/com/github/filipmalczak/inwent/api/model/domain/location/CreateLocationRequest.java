package com.github.filipmalczak.inwent.api.model.domain.location;

import com.github.filipmalczak.inwent.api.model.domain.content.ContentBody;

import java.net.URI;
import java.net.URL;

public record CreateLocationRequest(
    URL id,
    String type,
    URI contentId,
    ContentBody content
) {
}
