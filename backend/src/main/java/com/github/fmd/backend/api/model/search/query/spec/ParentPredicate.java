package com.github.fmd.backend.api.model.search.query.spec;

public record ParentPredicate(
    ParentSelector parent
) implements ParentSpec {
}
