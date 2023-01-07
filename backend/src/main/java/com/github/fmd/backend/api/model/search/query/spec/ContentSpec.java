package com.github.fmd.backend.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpecs.AllContentSpec.class,
        AnySpec.AnyContentSpec.class,
        NotSpec.NotContentSpec.class,
        ContentPredicate.class
    }
)
public sealed interface ContentSpec
    extends HitSelector
    permits AllSpecs.AllContentSpec, AnySpec.AnyContentSpec, NotSpec.NotContentSpec, ContentPredicate {
}
