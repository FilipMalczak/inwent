package com.github.filipmalczak.inwent.api.model.search.query.spec;

import java.net.URI;

public record URILiteral(
    URI uri
) implements ContentSelector {
}
