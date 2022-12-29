package com.github.fmd.backend.api.model;

import java.net.URI;
import java.util.List;

public record ContentDescriptor(
    URI uri,
    String title,
    String type,
    List<TagHits> tags
) {
}
