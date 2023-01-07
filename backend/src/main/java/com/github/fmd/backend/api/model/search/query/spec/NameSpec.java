package com.github.fmd.backend.api.model.search.query.spec;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSpecs.AllNameSpec.class,
        AnySpec.AnyNameSpec.class,
        NotSpec.NotNameSpec.class,
        NameLiteral.class,
        NamePredicate.class
    }
)
public sealed interface NameSpec
    extends NamespaceSelector, TagSelector, OriginSelector
    permits AllSpecs.AllNameSpec, AnySpec.AnyNameSpec, NotSpec.NotNameSpec, NameLiteral, NamePredicate {
}
