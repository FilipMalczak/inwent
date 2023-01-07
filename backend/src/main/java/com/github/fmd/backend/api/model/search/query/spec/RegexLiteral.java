package com.github.fmd.backend.api.model.search.query.spec;

public record RegexLiteral(
    String regex
) implements NameSelector, PathSelector {
}
