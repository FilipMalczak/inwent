package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.ConstraintContext;
import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;

@ConstraintContext
public record PathPredicate(
    PathSelector path
) implements PathSpec<PathPredicate>, Predicate<PathPredicate> {
    @Override
    public PathPredicate toCanonicalForm() {
        return new PathPredicate((PathSelector) path.toCanonicalForm());
    }
}
