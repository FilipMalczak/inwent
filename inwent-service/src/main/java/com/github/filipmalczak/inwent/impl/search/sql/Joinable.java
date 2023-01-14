package com.github.filipmalczak.inwent.impl.search.sql;


import java.util.Set;

public interface Joinable extends Sqlable {
    Set<QueriedTable> knownTables();
    Set<Condition> constraints();

    default Joinable join(Joinable other, Condition constraint) {
        return new JoinResult(
            this,
            other,
            constraint
        );
    }

    default Joinable joinIfNeeded(QueriedTable table, Condition constraint){
        if (knownTables().contains(table))
            return this;
        return join(table, constraint);
    }
}
