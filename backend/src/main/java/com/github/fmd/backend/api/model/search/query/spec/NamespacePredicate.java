package com.github.fmd.backend.api.model.search.query.spec;

public record NamespacePredicate(
    NamespaceSelector namespace
) implements com.github.fmd.backend.api.model.search.query.spec.NamespaceSpec {
}
