package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpec.AllContentSpec.class,
        AnySpec.AnyContentSpec.class,
        NotSpec.NotContentSpec.class,
        ContentPredicate.class
    }
)
public sealed interface ContentSpec<T extends ContentSpec<T>>
    extends HitSelector<T>, Spec<T>
    permits AllSpec.AllContentSpec, AnySpec.AnyContentSpec, NotSpec.NotContentSpec, ContentPredicate {
}
