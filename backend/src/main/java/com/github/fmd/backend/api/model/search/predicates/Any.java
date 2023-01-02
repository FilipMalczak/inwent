package com.github.fmd.backend.api.model.search.predicates;

import java.util.List;

public record Any<Pred extends RequestPredicate>(
    List<Pred> any
) implements CommonPredicate {
}
