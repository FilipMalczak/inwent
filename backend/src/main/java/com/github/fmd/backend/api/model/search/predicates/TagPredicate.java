package com.github.fmd.backend.api.model.search.predicates;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        CommonPredicate.class, Name.class, Namespace.class, Parent.class, Path.class
    }
)
public sealed interface TagPredicate
    extends RequestPredicate
    permits CommonPredicate, NamePredicate, NamespacePredicate, Name, Namespace, Parent, Path {
}
