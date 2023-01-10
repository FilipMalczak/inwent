package com.github.filipmalczak.inwent.impl.tag;

import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("tag")
@With
public record TagData(
    @Id UUID id,
    @Column("namespace_id") UUID namespaceId,
    @Column("tag_name") String name,
    @Column("parent_id") UUID parentId
) {
}
