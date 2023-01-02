package com.github.fmd.backend.api.model.search.predicates;

public sealed interface ContentPredicate extends RequestPredicate permits Url, Uri {
}
