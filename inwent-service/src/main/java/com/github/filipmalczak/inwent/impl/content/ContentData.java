package com.github.filipmalczak.inwent.impl.content;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.net.URI;
import java.time.Instant;

@Table("content")
public record ContentData(
    @Id Long id,
    String uri,
    String title,
    String type
    //todo add timestamps?
) {
}
