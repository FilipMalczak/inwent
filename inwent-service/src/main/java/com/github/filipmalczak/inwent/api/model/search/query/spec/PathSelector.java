package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        RegexLiteral.class,
        StringValueLiteral.class
    }
)
public sealed interface PathSelector<T extends PathSelector<T>>
    extends Selector<T>
    permits RegexLiteral, StringValueLiteral {
}
