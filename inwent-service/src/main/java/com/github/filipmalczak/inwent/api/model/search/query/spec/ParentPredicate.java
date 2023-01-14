package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;

public record ParentPredicate(
    ParentSelector parent
) implements ParentSpec<ParentPredicate>, Predicate<ParentPredicate> {
    @Override
    public ParentPredicate toCanonicalForm() {
        return new ParentPredicate((ParentSelector) parent.toCanonicalForm());
    }
}
