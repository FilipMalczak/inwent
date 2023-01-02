package com.github.fmd.backend.api.model.pointers.content;

import java.net.URI;

public record ContentId(
    URI contentId
) implements ContentPointer {
}
