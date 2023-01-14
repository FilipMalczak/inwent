package com.github.filipmalczak.inwent.api.model.search.query.spec;


import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpec.AllNameSpec.class,
        AnySpec.AnyNameSpec.class,
        NotSpec.NotNameSpec.class,
        NameLiteral.class,
        NamePredicate.class
    }
)
public sealed interface NameSpec<T extends NameSpec<T>>
    extends NamespaceSelector<T>, TagSelector<T>, OriginSelector<T>, Spec<T>
    permits AllSpec.AllNameSpec, AnySpec.AnyNameSpec, NotSpec.NotNameSpec, NameLiteral, NamePredicate {
}
