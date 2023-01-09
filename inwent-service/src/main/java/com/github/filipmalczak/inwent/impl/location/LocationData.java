package com.github.filipmalczak.inwent.impl.location;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.net.URI;
import java.net.URL;

@Table("location")
public record LocationData(
    @Id Long id,
    String url,
    String type,
    String contentId
) {
}
