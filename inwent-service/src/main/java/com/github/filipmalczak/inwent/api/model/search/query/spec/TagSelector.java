package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSelectors.AllTagSelector.class,
        AnySelector.AnyTagSelector.class,
        NotSelector.NotTagSelector.class,
        IdLiteral.class,
        NameSpec.class,
        NamespaceSpec.class,
        ParentSpec.class//,
        //PathSpec.class//todo reenable
    }
)
public sealed interface TagSelector
    extends ParentSelector
    permits AllSelectors.AllTagSelector, AnySelector.AnyTagSelector, NotSelector.NotTagSelector, IdLiteral, NameSpec, NamespaceSpec, ParentSpec/* fixme ditto , PathSpec */ {
}
