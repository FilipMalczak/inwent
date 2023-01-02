package com.github.fmd.backend.api.model.pointers.tag;

import java.util.UUID;

public record TagId(
    UUID id
) implements TagPointer {
}
