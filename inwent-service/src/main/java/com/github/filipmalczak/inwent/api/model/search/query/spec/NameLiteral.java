package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;

public record NameLiteral(
    String name
) implements NameSpec<NamePredicate>, Literal<NamePredicate> {
    @Override
    public NamePredicate toCanonicalForm() {
        return new NamePredicate(new StringValueLiteral(name));
    }
}
