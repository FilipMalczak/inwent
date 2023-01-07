package com.github.fmd.backend.api.model.search.query.spec;

public record ContentPredicate(
    ContentSelector content
) implements com.github.fmd.backend.api.model.search.query.spec.ContentSpec {
}
