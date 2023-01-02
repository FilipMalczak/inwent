package com.github.fmd.backend.api.model.search.query;

public record HitQuery(
    RenderClause render,
    WhereClause where
) {
}
