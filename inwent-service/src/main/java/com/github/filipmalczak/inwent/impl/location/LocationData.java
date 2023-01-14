package com.github.filipmalczak.inwent.impl.location;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("location")
public record LocationData(
    @Id Long id,
    String url,
    String type,
    String contentId
) {
}
