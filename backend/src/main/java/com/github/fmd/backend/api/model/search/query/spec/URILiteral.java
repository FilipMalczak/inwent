package com.github.fmd.backend.api.model.search.query.spec;

import java.net.URI;

public record URILiteral(
    URI uri
) implements ContentSelector {
}
