package com.github.fmd.backend.api.model.search.predicates;

public record Namespace(
    NamespacePredicate namespace
) implements TagPredicate {
}
