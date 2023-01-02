package com.github.fmd.backend.api.model.errors;

public record Error<T>(
    String description,
    T subject
) {
}
