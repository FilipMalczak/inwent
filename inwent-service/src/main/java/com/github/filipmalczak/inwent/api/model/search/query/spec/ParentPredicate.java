package com.github.filipmalczak.inwent.api.model.search.query.spec;

public record ParentPredicate(
    ParentSelector parent
) implements ParentSpec {
}
