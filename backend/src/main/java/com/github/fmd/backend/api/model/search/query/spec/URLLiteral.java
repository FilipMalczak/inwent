package com.github.fmd.backend.api.model.search.query.spec;

import java.net.URL;

public record URLLiteral(
    URL url
) implements ContentSelector {
}
