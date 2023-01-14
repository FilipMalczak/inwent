package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSpec.AllOriginSpec.class,
        GenericAnySpec.AnyOriginSpec.class,
        GenericNotSpec.NotOriginSpec.class,
        OriginLiteral.class,
        OriginPredicate.class
    }
)
public sealed interface OriginSpec<T extends OriginSpec<T>>
    extends HitSelector<T>, Spec<T>
    permits GenericAllSpec.AllOriginSpec, GenericAnySpec.AnyOriginSpec, GenericNotSpec.NotOriginSpec, OriginLiteral, OriginPredicate {
}
