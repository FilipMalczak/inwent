package com.github.fmd.backend.api.model.search.predicates;

import java.util.List;

public record All<Pred extends RequestPredicate>(
    List<Pred> all
) implements CommonPredicate {
}
