package com.github.filipmalczak.inwent.impl.search.sql;

import org.springframework.data.relational.core.query.Criteria;

import java.util.List;

public sealed interface Scope extends Condition  permits All, Any, Not {
    List<Condition> content();
    void add(Condition c);
}
