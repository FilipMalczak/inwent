package com.github.fmd.backend.api.model.search.predicates;

public record Name(
    String name
) implements NamePredicate, TagPredicate, OriginPredicate {
}
