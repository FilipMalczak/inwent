package com.github.fmd.backend.api.model.domain.content;

import com.github.fmd.backend.api.model.domain.hit.TagHits;

import java.net.URI;
import java.util.List;

public record ContentDescriptor(
    URI uri,
    String title,
    String type,
    List<TagHits> tags //todo this should come from hit query, remove
) {
}
