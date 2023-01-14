package com.github.filipmalczak.inwent.impl.search.sql;

import java.util.Set;

import static com.github.filipmalczak.inwent.impl.common.Misc.asSet;
import static java.util.Collections.emptySet;

public record QueriedTable(String tableName, String varName) implements Joinable {

    public QueriedColumn column(String name){
        return new QueriedColumn(varName, name);
    }

    @Override
    public String toSql() {
        return tableName + " " + varName;
    }

    @Override
    public Set<QueriedTable> knownTables() {
        return asSet(this);
    }

    @Override
    public Set<Condition> constraints() {
        return emptySet();
    }

}
