package com.github.filipmalczak.inwent.api.model.pointers.tag;

import java.util.UUID;

public record TagId(
    UUID id
) implements TagPointer {
}
