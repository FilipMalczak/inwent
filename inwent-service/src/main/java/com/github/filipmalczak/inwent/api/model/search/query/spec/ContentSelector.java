package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSelectors.AllContentSelector.class,
        AnySelector.AnyContentSelector.class,
        NotSelector.NotContentSelector.class,
        URILiteral.class,
        URLLiteral.class
    }
)
public sealed interface ContentSelector
    permits AllSelectors.AllContentSelector, AnySelector.AnyContentSelector, NotSelector.NotContentSelector, URILiteral, URLLiteral {
}
