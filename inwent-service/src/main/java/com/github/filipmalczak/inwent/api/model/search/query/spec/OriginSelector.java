package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        IdLiteral.class,
        NameSpec.class
    }
)
public sealed interface OriginSelector<T extends OriginSelector<T>>
    extends Selector<T>
    permits IdLiteral, NameSpec {
}
