package com.github.filipmalczak.inwent.api.model.domain.hit;

import com.github.filipmalczak.inwent.api.model.pointers.content.ContentPointer;
import com.github.filipmalczak.inwent.api.model.pointers.tag.TagPointer;

import java.util.List;
import java.util.UUID;

public record HitsBatchRequest(
    UUID originId,
    List<TagPointer> tags,
    List<ContentPointer> content
) {
}
