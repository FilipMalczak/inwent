package com.github.fmd.backend.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSelectors.AllTagSelector.class,
        AnySelector.AnyTagSelector.class,
        NotSelector.NotTagSelector.class,
        IdLiteral.class,
        NameSpec.class,
        NamespaceSpec.class,
        ParentSpec.class,
        PathSpec.class
    }
)
public sealed interface TagSelector
    extends ParentSelector
    permits AllSelectors.AllTagSelector, AnySelector.AnyTagSelector, NotSelector.NotTagSelector, IdLiteral, NameSpec, NamespaceSpec, ParentSpec, PathSpec {
}
