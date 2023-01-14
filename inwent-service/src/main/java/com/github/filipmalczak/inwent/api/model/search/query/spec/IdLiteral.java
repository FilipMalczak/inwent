package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.AtomicConstraint;
import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;

import java.util.UUID;

@AtomicConstraint
public record IdLiteral(
    UUID id
) implements TagSelector<IdLiteral>, NamespaceSelector<IdLiteral>, OriginSelector<IdLiteral>, Literal<IdLiteral> {
    @Override
    public IdLiteral toCanonicalForm() {
        return this;
    }
}
