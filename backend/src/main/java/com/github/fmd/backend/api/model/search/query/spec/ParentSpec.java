package com.github.fmd.backend.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpecs.AllParentSpec.class,
        AnySpec.AnyParentSpec.class,
        NotSpec.NotParentSpec.class,
        ParentPredicate.class
    }
)
public sealed interface ParentSpec
    extends TagSelector
    permits AllSpecs.AllParentSpec, AnySpec.AnyParentSpec, NotSpec.NotParentSpec, ParentPredicate {
}
