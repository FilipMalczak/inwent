package com.github.filipmalczak.inwent.api.model.search.query.spec;

public record NamespacePredicate(
    NamespaceSelector namespace
) implements com.github.filipmalczak.inwent.api.model.search.query.spec.NamespaceSpec {
}
