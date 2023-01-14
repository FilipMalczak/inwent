package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSelector.AllNamespaceSelector.class,
        GenericAnySelector.AnyNamespaceSelector.class,
        GenericNotSelector.NotNamespaceSelector.class,
        IdLiteral.class,
        NameSpec.class, //todo ?
        PathSpec.class
    }
)
public sealed interface NamespaceSelector<T extends NamespaceSelector<T>>
    extends Selector<T>
    permits GenericAllSelector.AllNamespaceSelector, GenericAnySelector.AnyNamespaceSelector, GenericNotSelector.NotNamespaceSelector, IdLiteral, NameSpec, PathSpec {
}
