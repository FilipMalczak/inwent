package com.github.fmd.backend.api.model.errors;

import java.util.List;

public record Issue(
    String name,
    List<Error> errors
) {
}
