package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        URILiteral.class,
        URLLiteral.class
    }
)
public sealed interface ContentSelector<T extends ContentSelector<T>>
    extends Selector<T>
    permits URILiteral, URLLiteral {
}
