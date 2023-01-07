package com.github.filipmalczak.inwent.api.model.domain.hit;

import java.net.URI;
import java.util.List;
import java.util.UUID;

public record HitsBatchResponse(
    UUID originId,
    List<UUID> tagIds,
    List<URI> contentIds
) {
}
