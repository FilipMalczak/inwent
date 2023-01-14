package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        IdLiteral.class,
        NameSpec.class,
        NamespaceSpec.class,
        ParentSpec.class//,
        //PathSpec.class//todo reenable
    }
)
public sealed interface TagSelector<T extends TagSelector<T>>
    //extends ParentSelector<T> //todo see ParentSelector
    extends Selector<T>
    permits IdLiteral, NameSpec, NamespaceSpec, ParentSpec/* fixme ditto , PathSpec */ {
}
