package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpec.AllOriginSpec.class,
        AnySpec.AnyOriginSpec.class,
        NotSpec.NotOriginSpec.class,
        OriginLiteral.class,
        OriginPredicate.class
    }
)
public sealed interface OriginSpec<T extends OriginSpec<T>>
    extends HitSelector<T>, Spec<T>
    permits AllSpec.AllOriginSpec, AnySpec.AnyOriginSpec, NotSpec.NotOriginSpec, OriginLiteral, OriginPredicate {
}
