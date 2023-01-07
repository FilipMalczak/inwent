package com.github.filipmalczak.inwent.api.model.search.query.spec;

import java.util.UUID;

public record IdLiteral(
    UUID id
) implements TagSelector, NamespaceSelector, OriginSelector {
}
