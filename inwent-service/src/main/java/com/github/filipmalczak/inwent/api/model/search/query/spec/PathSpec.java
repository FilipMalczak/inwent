package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSpec.AllPathSpec.class,
        GenericAnySpec.AnyPathSpec.class,
        GenericNotSpec.NotPathSpec.class,
        PathLiteral.class,
        PathPredicate.class
    }
)
public sealed interface PathSpec<T extends PathSpec<T>>
    extends NamespaceSelector<T>, Spec<T>//, TagSelector //todo reenable
    permits GenericAllSpec.AllPathSpec, GenericAnySpec.AnyPathSpec, GenericNotSpec.NotPathSpec, PathLiteral, PathPredicate {
}
