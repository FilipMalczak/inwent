package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;

public record OriginLiteral(
    String origin
) implements OriginSpec<OriginPredicate>, Literal<OriginPredicate> {
    @Override
    public OriginPredicate toCanonicalForm() {
        return new OriginPredicate(new NamePredicate(new StringValueLiteral(origin)));
    }
}
