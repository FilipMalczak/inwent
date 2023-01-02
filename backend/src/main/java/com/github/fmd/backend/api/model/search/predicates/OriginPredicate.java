package com.github.fmd.backend.api.model.search.predicates;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        CommonPredicate.class, Name.class
    }
)
public sealed interface OriginPredicate extends RequestPredicate permits CommonPredicate, Name {
}
