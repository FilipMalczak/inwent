package com.github.filipmalczak.inwent.impl.search.sql;

public record QueriedColumn(String variable, String name) implements Sqlable {

    @Override
    public String toSql() {
        return variable+"."+name;
    }
}
