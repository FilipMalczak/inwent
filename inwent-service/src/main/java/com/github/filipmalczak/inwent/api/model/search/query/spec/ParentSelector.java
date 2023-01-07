package com.github.filipmalczak.inwent.api.model.search.query.spec;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        AllSelectors.AllParentSelector.class,
        AnySelector.AnyParentSelector.class,
        NotSelector.NotParentSelector.class,
        TagSelector.class,
        TagSpec.class
    }
)
public sealed interface ParentSelector
    permits AllSelectors.AllParentSelector, AnySelector.AnyParentSelector, NotSelector.NotParentSelector, TagSelector, TagSpec {
}
