package com.github.fmd.backend.api.model.domain.hit;

import com.github.fmd.backend.api.model.pointers.content.ContentPointer;
import com.github.fmd.backend.api.model.pointers.tag.TagPointer;

import java.util.List;
import java.util.UUID;

public record HitsBatchRequest(
    UUID originId,
    List<TagPointer> tags,
    List<ContentPointer> content
) {
}
