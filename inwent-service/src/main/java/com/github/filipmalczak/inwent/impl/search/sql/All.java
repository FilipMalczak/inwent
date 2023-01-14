package com.github.filipmalczak.inwent.impl.search.sql;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.filipmalczak.inwent.impl.common.Misc.parenthesised;

public record All(Collection<Condition> children) implements Condition {
    @Override
    public String toSql() {
        return children.stream().map(Sqlable::toSql).map(parenthesised).sorted().collect(Collectors.joining(" AND "));
    }
}
