package com.github.fmd.backend.api.model.search.query;

import com.github.fmd.backend.api.model.search.query.spec.HitSelector;

import java.util.List;

public record HitQuery(
    RenderClause render,
    List<HitSelector> where
) {
}
