package com.github.fmd.backend.api.model.search.predicates;

import java.net.URI;

public record Uri(
    URI uri
) implements ContentPredicate {
}
