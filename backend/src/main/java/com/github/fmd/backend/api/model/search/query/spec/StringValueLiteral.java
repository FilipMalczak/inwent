package com.github.fmd.backend.api.model.search.query.spec;

public record StringValueLiteral(
    String value
) implements NameSelector, PathSelector {
}
