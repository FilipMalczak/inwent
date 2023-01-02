package com.github.fmd.backend.api.model.search.predicates;

public record Not<Pred extends RequestPredicate> (
    Pred not
) implements CommonPredicate {
}
