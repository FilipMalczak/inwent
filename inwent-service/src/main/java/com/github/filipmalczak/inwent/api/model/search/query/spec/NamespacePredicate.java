package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;

public record NamespacePredicate(
    NamespaceSelector namespace
) implements NamespaceSpec<NamespacePredicate>, Predicate<NamespacePredicate> {
    @Override
    public NamespacePredicate toCanonicalForm() {
        return new NamespacePredicate((NamespaceSelector) namespace.toCanonicalForm());
    }
}
