package com.github.filipmalczak.inwent.impl.search.sql;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

public sealed interface Condition extends Sqlable permits Explicit, Scope {
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @AllArgsConstructor
    enum Operator implements Sqlable {
        EQUALS("="), MATCHES("~");

        String sql;

        @Override
        public String toSql() {
            return sql;
        }
    }
}
