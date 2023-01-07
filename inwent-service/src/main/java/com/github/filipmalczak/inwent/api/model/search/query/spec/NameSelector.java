package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSelectors.AllNameSelector.class,
        AnySelector.AnyNameSelector.class,
        NotSelector.NotNameSelector.class,
        RegexLiteral.class,
        StringValueLiteral.class
    }
)
public sealed interface NameSelector
    permits AllSelectors.AllNameSelector, AnySelector.AnyNameSelector, NotSelector.NotNameSelector, RegexLiteral, StringValueLiteral {
}
