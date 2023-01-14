package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Spec;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        GenericAllSpec.AllNamespaceSpec.class,
        GenericAnySpec.AnyNamespaceSpec.class,
        GenericNotSpec.NotNamespaceSpec.class,
        NamespaceLiteral.class,
        NamespacePredicate.class
    }
)
public sealed interface NamespaceSpec<T extends NamespaceSpec<T>>
    extends TagSelector<T>, Spec<T>
    permits GenericAllSpec.AllNamespaceSpec, GenericAnySpec.AnyNamespaceSpec, GenericNotSpec.NotNamespaceSpec, NamespaceLiteral, NamespacePredicate {
}
