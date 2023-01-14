package com.github.filipmalczak.inwent.impl.content;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("content")
public record ContentData(
    @Id Long id,
    String uri,
    String title,
    String type
    //todo add timestamps?
) {
}
