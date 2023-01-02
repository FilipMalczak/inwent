package com.github.fmd.backend.api.model.search.query;

import com.github.fmd.backend.api.model.search.component.ContentComponent;
import com.github.fmd.backend.api.model.search.component.OriginComponent;
import com.github.fmd.backend.api.model.search.component.TagComponent;

import java.util.Set;

public record RenderClause(
    Set<TagComponent> tags,
    Set<OriginComponent> origins,
    Set<ContentComponent> content
) {
}
