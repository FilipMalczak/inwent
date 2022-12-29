package com.github.fmd.backend.api.model;

import java.net.URI;
import java.net.URL;

public record CreateLocationRequest(
    URL id,
    URI contentId,
    ContentBody content
) {
}
