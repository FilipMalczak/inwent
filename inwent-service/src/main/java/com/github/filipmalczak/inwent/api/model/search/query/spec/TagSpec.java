package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpec.AllTagSpec.class,
        AnySpec.AnyTagSpec.class,
        NotSpec.NotTagSpec.class,
        TagLiteral.class,
        TagPredicate.class
    }
)
public sealed interface TagSpec<T extends TagSpec<T>>
    extends ParentSelector<T>, HitSelector<T>, Spec<T>
    permits AllSpec.AllTagSpec, AnySpec.AnyTagSpec, NotSpec.NotTagSpec, TagLiteral, TagPredicate {
}
