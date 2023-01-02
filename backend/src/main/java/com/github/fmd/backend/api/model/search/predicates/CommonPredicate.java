package com.github.fmd.backend.api.model.search.predicates;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        NamePredicate.class, NamespacePredicate.class, TagPredicate.class, OriginPredicate.class
    }
)
public sealed interface CommonPredicate
    extends NamePredicate, NamespacePredicate, TagPredicate, OriginPredicate
    permits All, Any, Id, Not
{
}
