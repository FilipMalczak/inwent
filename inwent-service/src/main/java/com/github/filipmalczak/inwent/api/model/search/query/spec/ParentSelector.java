package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    anyOf = {
        //TagSelector.class, //todo allowing for tag selectors directly in parent predicate is readable, but is a bitch to parse
        TagSpec.class
    }
)
public sealed interface ParentSelector<T extends ParentSelector<T>>
    extends Selector<T>
    permits /*TagSelector, */TagSpec {
}
