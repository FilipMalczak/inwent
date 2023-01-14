package com.github.filipmalczak.inwent.impl.search.sql;

public record Sql(String value) implements Sqlable {
    @Override
    public String toSql() {
        return value;
    }
}
