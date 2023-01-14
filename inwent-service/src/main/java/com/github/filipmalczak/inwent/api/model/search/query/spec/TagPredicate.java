package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;

public record TagPredicate(
    TagSelector tag
) implements TagSpec<TagPredicate>, Predicate<TagPredicate> {
    @Override
    public TagPredicate toCanonicalForm() {
        return new TagPredicate((TagSelector) tag.toCanonicalForm());
    }
}
