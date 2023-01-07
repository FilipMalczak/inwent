package com.github.fmd.backend.api.model.search.query.spec;

import java.util.UUID;

public record IdLiteral(
    UUID id
) implements TagSelector, NamespaceSelector, OriginSelector {
}
