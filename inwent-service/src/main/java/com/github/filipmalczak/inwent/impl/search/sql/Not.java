package com.github.filipmalczak.inwent.impl.search.sql;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.valid4j.Assertive.require;

public record Not(List<Condition> children) implements Scope {

    @Override
    public String toSql() {
        //todo dedicated
        require(children.size() == 1);
        return "NOT ("+children.get(0).toSql()+")";
    }

    @Override
    public List<Condition> content() {
        return children;
    }

    @Override
    public void add(Condition c) {
        require(children.isEmpty());
        children.add(c);
    }
}
