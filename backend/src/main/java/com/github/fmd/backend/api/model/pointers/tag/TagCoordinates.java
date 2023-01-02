package com.github.fmd.backend.api.model.pointers.tag;

public record TagCoordinates(
    String namespace,
    String name
) implements TagPointer {
}
