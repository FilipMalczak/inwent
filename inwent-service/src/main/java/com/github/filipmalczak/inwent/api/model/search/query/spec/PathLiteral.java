package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;

public record PathLiteral(
    String path
) implements PathSpec<PathPredicate>, Literal<PathPredicate> {
    @Override
    public PathPredicate toCanonicalForm() {
        return new PathPredicate(new StringValueLiteral(path));
    }
}
