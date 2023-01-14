package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSelector.AllNameSelector.class,
        GenericAnySelector.AnyNameSelector.class,
        GenericNotSelector.NotNameSelector.class,
        RegexLiteral.class,
        StringValueLiteral.class
    }
)
public sealed interface NameSelector<T extends NameSelector<T>>
    extends Selector<T>
    permits GenericAllSelector.AllNameSelector, GenericAnySelector.AnyNameSelector, GenericNotSelector.NotNameSelector, RegexLiteral, StringValueLiteral {
}
