package com.github.filipmalczak.inwent.api.model.search.query.spec;

import java.net.URL;

public record URLLiteral(
    URL url
) implements ContentSelector {
}
