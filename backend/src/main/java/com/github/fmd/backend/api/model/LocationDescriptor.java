package com.github.fmd.backend.api.model;

import java.net.URI;
import java.net.URL;

public record LocationDescriptor(
    URL id,
    String type,
    URI contentId,
    ContentDescriptor content
) {
}
