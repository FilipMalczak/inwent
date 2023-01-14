package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpec.AllParentSpec.class,
        AnySpec.AnyParentSpec.class,
        NotSpec.NotParentSpec.class,
        ParentPredicate.class
    }
)
public sealed interface ParentSpec<T extends ParentSpec<T>>
    extends TagSelector<T>, Spec<T>
    permits AllSpec.AllParentSpec, AnySpec.AnyParentSpec, NotSpec.NotParentSpec, ParentPredicate {
}
