package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        TagSpec.class,
        OriginSpec.class,
        ContentSpec.class
    }
)
public sealed interface HitSelector
    permits TagSpec, OriginSpec, ContentSpec {
}
