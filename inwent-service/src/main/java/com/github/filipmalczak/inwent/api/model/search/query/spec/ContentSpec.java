package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm;
import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSpec.AllContentSpec.class,
        GenericAnySpec.AnyContentSpec.class,
        GenericNotSpec.NotContentSpec.class,
        ContentPredicate.class
    }
)
public sealed interface ContentSpec<T extends ContentSpec<T>>
    extends HitSelector<T>, Spec<T>
    permits GenericAllSpec.AllContentSpec, GenericAnySpec.AnyContentSpec, GenericNotSpec.NotContentSpec, ContentPredicate {
}
