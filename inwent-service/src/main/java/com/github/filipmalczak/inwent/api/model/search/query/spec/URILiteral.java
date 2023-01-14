package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;

import java.net.URI;

public record URILiteral(
    URI uri
) implements ContentSelector<URILiteral>, Literal<URILiteral> {
    @Override
    public URILiteral toCanonicalForm() {
        return this;
    }
}
