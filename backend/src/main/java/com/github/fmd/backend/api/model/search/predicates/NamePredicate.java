package com.github.fmd.backend.api.model.search.predicates;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        CommonPredicate.class, Name.class, Regex.class
    }
)
public sealed interface NamePredicate extends RequestPredicate, TagPredicate permits CommonPredicate, Name, Regex {
}
