package com.github.fmd.backend.api.model.search.query.spec;

public record TagPredicate(
    TagSelector tag
) implements TagSpec {
}
