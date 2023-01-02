package com.github.fmd.backend.api.model.domain.location;

import com.github.fmd.backend.api.model.domain.content.ContentBody;

import java.net.URI;
import java.net.URL;

public record CreateLocationRequest(
    URL id,
    URI contentId,
    ContentBody content
) {
}
