package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm;
import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSelector.AllContentSelector.class,
        GenericAnySelector.AnyContentSelector.class,
        GenericNotSelector.NotContentSelector.class,
        URILiteral.class,
        URLLiteral.class
    }
)
public sealed interface ContentSelector<T extends ContentSelector<T>>
    extends Selector<T>
    permits GenericAllSelector.AllContentSelector, GenericAnySelector.AnyContentSelector, GenericNotSelector.NotContentSelector, URILiteral, URLLiteral {
}
