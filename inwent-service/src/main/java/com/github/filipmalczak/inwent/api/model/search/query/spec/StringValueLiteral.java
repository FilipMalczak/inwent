package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;

public record StringValueLiteral(
    String value
) implements NameSelector<StringValueLiteral>, PathSelector<StringValueLiteral>, Literal<StringValueLiteral> {
    @Override
    public StringValueLiteral toCanonicalForm() {
        return this;
    }
}
