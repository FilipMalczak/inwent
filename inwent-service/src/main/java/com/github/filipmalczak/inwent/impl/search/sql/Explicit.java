package com.github.filipmalczak.inwent.impl.search.sql;

public record Explicit(QueriedColumn subject, Condition.Operator operator, Sqlable arg) implements Condition {
    @Override
    public String toSql() {
        return subject.toSql()+" "+operator.toSql()+" "+arg.toSql();
    }

}
