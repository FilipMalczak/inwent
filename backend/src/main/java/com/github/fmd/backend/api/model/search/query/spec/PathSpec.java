package com.github.fmd.backend.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpecs.AllPathSpec.class,
        AnySpec.AnyPathSpec.class,
        NotSpec.NotPathSpec.class,
        PathLiteral.class,
        PathPredicate.class
    }
)
public sealed interface PathSpec
    extends NamespaceSelector, TagSelector
    permits AllSpecs.AllPathSpec, AnySpec.AnyPathSpec, NotSpec.NotPathSpec, PathLiteral, PathPredicate {
}
