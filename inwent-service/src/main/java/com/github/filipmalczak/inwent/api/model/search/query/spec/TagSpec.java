package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpecs.AllTagSpec.class,
        AnySpec.AnyTagSpec.class,
        NotSpec.NotTagSpec.class,
        TagLiteral.class,
        TagPredicate.class
    }
)
public sealed interface TagSpec
    extends ParentSelector, HitSelector
    permits AllSpecs.AllTagSpec, AnySpec.AnyTagSpec, NotSpec.NotTagSpec, TagLiteral, TagPredicate {
}
