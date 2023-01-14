package com.github.filipmalczak.inwent.impl.search.sql;

import java.util.List;
import java.util.stream.Collectors;

import static com.github.filipmalczak.inwent.impl.common.Misc.parenthesised;

public record Any(List<Condition> children) implements Scope {
    @Override
    public String toSql() {
        return children.stream().map(Sqlable::toSql).map(parenthesised).sorted().collect(Collectors.joining(" OR "));
    }

    @Override
    public List<Condition> content() {
        return children;
    }

    @Override
    public void add(Condition c) {
        children.add(c);
    }
}
