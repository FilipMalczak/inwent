package com.github.filipmalczak.inwent.api.model.search.query.spec;

public record StringValueLiteral(
    String value
) implements NameSelector, PathSelector {
}
