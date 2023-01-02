package com.github.fmd.backend.api.model.search.predicates;

//this SHOULD NOT be visible as schema, its just in case that I need a common supertype for generics
public sealed interface RequestPredicate permits ContentPredicate, NamePredicate, NamespacePredicate, OriginPredicate, TagPredicate {
}
