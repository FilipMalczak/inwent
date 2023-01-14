package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;

import java.net.URL;

public record URLLiteral(
    URL url
) implements ContentSelector<URLLiteral>, Literal<URLLiteral> {
    @Override
    public URLLiteral toCanonicalForm() {
        return this;
    }
}
