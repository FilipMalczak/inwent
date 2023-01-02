package com.github.fmd.backend.api.model.pointers.content;

import java.net.URL;

public record LocationId(
    URL url
) implements ContentPointer {
}
