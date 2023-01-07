package com.github.fmd.backend.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpecs.AllNamespaceSpec.class,
        AnySpec.AnyNamespaceSpec.class,
        NotSpec.NotNamespaceSpec.class,
        NamespaceLiteral.class,
        NamespacePredicate.class
    }
)
public sealed interface NamespaceSpec
    extends TagSelector
    permits AllSpecs.AllNamespaceSpec, AnySpec.AnyNamespaceSpec, NotSpec.NotNamespaceSpec, NamespaceLiteral, NamespacePredicate {
}
