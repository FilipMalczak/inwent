package com.github.filipmalczak.inwent.impl.search.sql;

import static java.util.stream.Collectors.joining;

record Not(Condition child) implements Condition {
    @Override
    public String toSql() {
        return "NOT ("+child.toSql()+")";
    }
}
