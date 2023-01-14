package com.github.filipmalczak.inwent.api.model.search.query;

import com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm;
import com.github.filipmalczak.inwent.api.model.search.query.spec.HitSelector;

import java.util.List;

public record HitQuery(
    RenderClause render,
    List<HitSelector> where
) implements HasCanonicalForm<HitQuery> {
    @Override
    public HitQuery toCanonicalForm() {
        return new HitQuery(
            render, //todo canonical?
            where.stream().map(HasCanonicalForm::toCanonicalForm).map(x -> (HitSelector) x).toList()
        );
    }
}
