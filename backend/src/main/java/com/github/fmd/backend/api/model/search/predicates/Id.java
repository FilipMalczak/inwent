package com.github.fmd.backend.api.model.search.predicates;

public record Id<T>(
    T id
) implements CommonPredicate {
}
