package com.github.filipmalczak.inwent.impl.hit;

import com.github.filipmalczak.inwent.impl.content.ContentData;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("hit")
public record HitData(
    @Id Long id,
    @Column("content_id") Long contentInternalId,
    @Column("origin_id") UUID originId,
    @Column("tag_id") UUID tagId
) {
}
