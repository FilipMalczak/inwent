package com.github.filipmalczak.inwent.api.model.errors;

public record Error<T>(
    String description,
    T subject
) {
}
