package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpecs.AllOriginSpec.class,
        AnySpec.AnyOriginSpec.class,
        NotSpec.NotOriginSpec.class,
        OriginLiteral.class,
        OriginPredicate.class
    }
)
public sealed interface OriginSpec
    extends HitSelector
    permits AllSpecs.AllOriginSpec, AnySpec.AnyOriginSpec, NotSpec.NotOriginSpec, OriginLiteral, OriginPredicate {
}
