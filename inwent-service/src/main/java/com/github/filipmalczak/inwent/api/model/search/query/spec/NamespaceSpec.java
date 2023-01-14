package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpec.AllNamespaceSpec.class,
        AnySpec.AnyNamespaceSpec.class,
        NotSpec.NotNamespaceSpec.class,
        NamespaceLiteral.class,
        NamespacePredicate.class
    }
)
public sealed interface NamespaceSpec<T extends NamespaceSpec<T>>
    extends TagSelector<T>, Spec<T>
    permits AllSpec.AllNamespaceSpec, AnySpec.AnyNamespaceSpec, NotSpec.NotNamespaceSpec, NamespaceLiteral, NamespacePredicate {
}
