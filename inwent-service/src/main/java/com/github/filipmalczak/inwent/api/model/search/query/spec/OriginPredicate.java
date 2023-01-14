package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.ConstraintContext;
import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;

@ConstraintContext
public record OriginPredicate(
    OriginSelector origin
) implements com.github.filipmalczak.inwent.api.model.search.query.spec.OriginSpec<OriginPredicate>, Predicate<OriginPredicate> {
    @Override
    public OriginPredicate toCanonicalForm() {
        return new OriginPredicate((OriginSelector) origin.toCanonicalForm());
    }
}
