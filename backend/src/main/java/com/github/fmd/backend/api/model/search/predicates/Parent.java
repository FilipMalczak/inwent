package com.github.fmd.backend.api.model.search.predicates;

public record Parent(
    TagPredicate parent
) implements TagPredicate {
}
