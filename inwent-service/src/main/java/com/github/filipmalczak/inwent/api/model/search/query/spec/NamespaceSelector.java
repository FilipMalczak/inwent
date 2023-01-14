package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        IdLiteral.class,
        NameSpec.class, //todo ?
        PathSpec.class
    }
)
public sealed interface NamespaceSelector<T extends NamespaceSelector<T>>
    extends Selector<T>
    permits IdLiteral, NameSpec, PathSpec {
}
