package com.github.filipmalczak.inwent.impl.search.sql;

public record SqlStr(String txt) implements Sqlable {
    @Override
    public String toSql() {
        return "\""+txt.replaceAll("[\"]", "\"\"")+"\"";
    }
}
