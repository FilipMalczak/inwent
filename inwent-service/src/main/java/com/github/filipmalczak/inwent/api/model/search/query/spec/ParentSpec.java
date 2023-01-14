package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSpec.AllParentSpec.class,
        GenericAnySpec.AnyParentSpec.class,
        GenericNotSpec.NotParentSpec.class,
        ParentPredicate.class
    }
)
public sealed interface ParentSpec<T extends ParentSpec<T>>
    extends TagSelector<T>, Spec<T>
    permits GenericAllSpec.AllParentSpec, GenericAnySpec.AnyParentSpec, GenericNotSpec.NotParentSpec, ParentPredicate {
}
