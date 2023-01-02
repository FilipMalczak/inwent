package com.github.fmd.backend.api.model.search.predicates;

public record Regex(
    String rgx
) implements NamespacePredicate, NamePredicate {
}
