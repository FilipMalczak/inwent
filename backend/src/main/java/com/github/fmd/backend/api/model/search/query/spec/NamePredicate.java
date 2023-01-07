package com.github.fmd.backend.api.model.search.query.spec;

public record NamePredicate(
    NameSelector name
) implements com.github.fmd.backend.api.model.search.query.spec.NameSpec {
}
