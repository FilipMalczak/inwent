package com.github.filipmalczak.inwent.api.model.pointers.content;


import com.github.filipmalczak.inwent.api.model.pointers.Pointer;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        ContentId.class, LocationId.class
    }
)
public sealed interface ContentPointer extends Pointer permits ContentId, LocationId {
}
