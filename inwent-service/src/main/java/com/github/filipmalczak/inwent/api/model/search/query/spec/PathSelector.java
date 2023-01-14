package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSelector.AllPathSelector.class,
        GenericAnySelector.AnyPathSelector.class,
        GenericNotSelector.NotPathSelector.class,
        RegexLiteral.class,
        StringValueLiteral.class
    }
)
public sealed interface PathSelector<T extends PathSelector<T>>
    extends Selector<T>
    permits GenericAllSelector.AllPathSelector, GenericAnySelector.AnyPathSelector, GenericNotSelector.NotPathSelector, RegexLiteral, StringValueLiteral {
}
