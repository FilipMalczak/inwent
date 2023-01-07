package com.github.filipmalczak.inwent.api.model.search.query.spec;

public record RegexLiteral(
    String regex
) implements NameSelector, PathSelector {
}
