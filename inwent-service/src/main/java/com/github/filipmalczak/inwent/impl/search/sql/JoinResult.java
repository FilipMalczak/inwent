package com.github.filipmalczak.inwent.impl.search.sql;

import java.util.HashSet;
import java.util.Set;

public record JoinResult(Joinable left, Joinable right, Condition constraint) implements Joinable {
    @Override
    public Set<QueriedTable> knownTables() {
        var out = new HashSet<>(left.knownTables());
        out.addAll(right.knownTables());
        return out;
    }

    @Override
    public Set<Condition> constraints() {
        var out = new HashSet<>(left.constraints());
        out.addAll(right.constraints());
        out.add(constraint);
        return out;
    }

    @Override
    public String toSql() {
        return left.toSql()+" JOIN "+right.toSql()+" ON "+constraint.toSql();
    }
}
