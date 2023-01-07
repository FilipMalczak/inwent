package com.github.filipmalczak.inwent.api.model.errors;

import java.util.List;

public record Issue(
    String name,
    List<Error> errors
) {
}
