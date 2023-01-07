package com.github.fmd.backend.api.model.search.query.spec;

public record PathPredicate(
    PathSelector path
) implements com.github.fmd.backend.api.model.search.query.spec.PathSpec {
}
