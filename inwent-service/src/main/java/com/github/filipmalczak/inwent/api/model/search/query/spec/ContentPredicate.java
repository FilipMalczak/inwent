package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;

public record ContentPredicate(
    ContentSelector content
) implements ContentSpec<ContentPredicate>, Predicate<ContentPredicate> {
    @Override
    public ContentPredicate toCanonicalForm() {
        return new ContentPredicate((ContentSelector) content.toCanonicalForm());
    }
}
