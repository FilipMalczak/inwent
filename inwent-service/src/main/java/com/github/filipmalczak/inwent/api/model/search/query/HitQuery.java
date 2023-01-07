package com.github.filipmalczak.inwent.api.model.search.query;

import com.github.filipmalczak.inwent.api.model.search.query.spec.HitSelector;

import java.util.List;

public record HitQuery(
    RenderClause render,
    List<HitSelector> where
) {
}
