package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.ConstraintContext;
import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;

@ConstraintContext
public record NamePredicate(
    NameSelector name
) implements NameSpec<NamePredicate>, Predicate<NamePredicate> {
    @Override
    public NamePredicate toCanonicalForm() {
        return new NamePredicate((NameSelector) name.toCanonicalForm());
    }
}
