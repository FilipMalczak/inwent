package com.github.filipmalczak.inwent.impl.tag;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("namespace")
public record NamespaceData(
    @Id UUID id,
    @Column("namespace_path") String path
    ) {
}
