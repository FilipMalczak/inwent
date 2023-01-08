package com.github.filipmalczak.inwent.impl;

import org.springframework.data.annotation.Id;

public record Foo(@Id Long id, String name) {
}
