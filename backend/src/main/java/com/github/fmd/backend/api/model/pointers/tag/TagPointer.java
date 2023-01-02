package com.github.fmd.backend.api.model.pointers.tag;

import com.github.fmd.backend.api.model.pointers.Pointer;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        TagId.class, TagCoordinates.class
    }
)
public sealed interface TagPointer extends Pointer permits TagCoordinates, TagId {
}
