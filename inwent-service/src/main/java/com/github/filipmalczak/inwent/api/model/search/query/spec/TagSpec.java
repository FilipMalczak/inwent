package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSpec.AllTagSpec.class,
        GenericAnySpec.AnyTagSpec.class,
        GenericNotSpec.NotTagSpec.class,
        TagLiteral.class,
        TagPredicate.class
    }
)
public sealed interface TagSpec<T extends TagSpec<T>>
    extends ParentSelector<T>, HitSelector<T>, Spec<T>
    permits GenericAllSpec.AllTagSpec, GenericAnySpec.AnyTagSpec, GenericNotSpec.NotTagSpec, TagLiteral, TagPredicate {
}
