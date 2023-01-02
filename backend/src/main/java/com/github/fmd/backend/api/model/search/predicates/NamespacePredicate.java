package com.github.fmd.backend.api.model.search.predicates;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        CommonPredicate.class, Path.class, Regex.class
    }
)
public sealed interface NamespacePredicate extends RequestPredicate, TagPredicate permits CommonPredicate, Path, Regex {
}
