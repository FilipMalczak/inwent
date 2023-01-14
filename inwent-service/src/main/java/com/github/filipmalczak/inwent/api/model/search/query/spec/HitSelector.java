package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        TagSpec.class,
        OriginSpec.class,
        ContentSpec.class
    }
)
public sealed interface HitSelector<T extends HitSelector<T>>
    extends Selector<T>
    permits TagSpec, OriginSpec, ContentSpec {
}
