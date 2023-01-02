package com.github.fmd.backend.api.model.search.predicates;

/**
 * Path as tag predicate refers to parent-child hierarchy
 */
public record Path(
    String path
) implements NamespacePredicate, TagPredicate {
}
