package com.github.filipmalczak.inwent.api.model.search.query;

import com.github.filipmalczak.inwent.api.model.search.component.ContentComponent;
import com.github.filipmalczak.inwent.api.model.search.component.OriginComponent;
import com.github.filipmalczak.inwent.api.model.search.component.TagComponent;

import java.util.Set;

public record RenderClause(
    Set<TagComponent> tags,
    Set<OriginComponent> origins,
    Set<ContentComponent> content
) {
}
