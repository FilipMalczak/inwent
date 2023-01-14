package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;

public record RegexLiteral(
    String regex
) implements NameSelector<RegexLiteral>, PathSelector<RegexLiteral>, Literal<RegexLiteral> {
    @Override
    public RegexLiteral toCanonicalForm() {
        return this;
    }
}
