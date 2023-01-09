package com.github.filipmalczak.inwent.impl.origin;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("origin")
public record OriginData(
    @Id UUID id,
    @Column("origin_name") String name
    ) {
}
