package com.github.filipmalczak.inwent.api.model.pointers.content;

import java.net.URL;

public record LocationId(
    URL url
) implements ContentPointer {
}
