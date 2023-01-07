package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSelectors.AllNamespaceSelector.class,
        AnySelector.AnyNamespaceSelector.class,
        NotSelector.NotNamespaceSelector.class,
        IdLiteral.class,
        NameSpec.class,
        PathSpec.class
    }
)
public sealed interface NamespaceSelector
    permits AllSelectors.AllNamespaceSelector, AnySelector.AnyNamespaceSelector, NotSelector.NotNamespaceSelector, IdLiteral, NameSpec, PathSpec {
}
