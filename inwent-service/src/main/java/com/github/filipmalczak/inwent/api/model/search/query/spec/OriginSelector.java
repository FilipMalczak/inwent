package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSelectors.AllOriginSelector.class,
        AnySelector.AnyOriginSelector.class,
        NotSelector.NotOriginSelector.class,
        IdLiteral.class,
        NameSpec.class
    }
)
public sealed interface OriginSelector
    permits AllSelectors.AllOriginSelector, AnySelector.AnyOriginSelector, NotSelector.NotOriginSelector, IdLiteral, NameSpec {
}
