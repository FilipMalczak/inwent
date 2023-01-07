package com.github.filipmalczak.inwent.api.model.pointers.tag;

public record TagCoordinates(
    String namespace,
    String name
) implements TagPointer {
}
