package com.github.fmd.backend.api.model.search.predicates;

import java.net.URL;

public record Url(
    URL url
) implements ContentPredicate {
}
