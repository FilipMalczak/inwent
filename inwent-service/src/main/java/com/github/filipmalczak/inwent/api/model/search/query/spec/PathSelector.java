package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSelectors.AllPathSelector.class,
        AnySelector.AnyPathSelector.class,
        NotSelector.NotPathSelector.class,
        RegexLiteral.class,
        StringValueLiteral.class
    }
)
public sealed interface PathSelector permits AllSelectors.AllPathSelector, AnySelector.AnyPathSelector, NotSelector.NotPathSelector, RegexLiteral, StringValueLiteral {
}
