package com.github.filipmalczak.inwent.api.model.search.query.spec;

public record ContentPredicate(
    ContentSelector content
) implements com.github.filipmalczak.inwent.api.model.search.query.spec.ContentSpec {
}
