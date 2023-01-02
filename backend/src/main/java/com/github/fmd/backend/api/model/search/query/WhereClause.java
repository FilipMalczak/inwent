package com.github.fmd.backend.api.model.search.query;

import com.github.fmd.backend.api.model.search.predicates.ContentPredicate;
import com.github.fmd.backend.api.model.search.predicates.OriginPredicate;
import com.github.fmd.backend.api.model.search.predicates.TagPredicate;

public record WhereClause(
    OriginPredicate origin,
    ContentPredicate content,
    TagPredicate tag
) {
}
