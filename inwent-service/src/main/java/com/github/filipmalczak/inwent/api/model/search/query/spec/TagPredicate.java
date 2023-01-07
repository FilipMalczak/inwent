package com.github.filipmalczak.inwent.api.model.search.query.spec;

public record TagPredicate(
    TagSelector tag
) implements TagSpec {
}
