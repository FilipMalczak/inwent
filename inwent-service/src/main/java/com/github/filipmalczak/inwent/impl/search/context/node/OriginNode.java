package com.github.filipmalczak.inwent.impl.search.context.node;

import com.github.filipmalczak.inwent.impl.search.context.node.selector.SelectorNotSupportedException;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.Condition;
import com.github.filipmalczak.inwent.impl.search.sql.Explicit;
import com.github.filipmalczak.inwent.impl.search.sql.QueriedTable;
import com.github.filipmalczak.inwent.impl.search.sql.SqlStr;

public class OriginNode implements TerminalNode {
    private static final QueriedTable ORIGIN_TABLE = new QueriedTable("origin", "o");

    @Override
    public QueriedTable table() {
        return ORIGIN_TABLE;
    }

    @Override
    public Selectors selectors() {
        return new Selectors() {
            @Override
            public Condition id(String id) {
                return new Explicit(ORIGIN_TABLE.column("id"), Condition.Operator.EQUALS, new SqlStr(id));
            }

            @Override
            public Condition name(Condition.Operator operator, String rhs) {
                return new Explicit(ORIGIN_TABLE.column("name"), operator, new SqlStr(rhs));
            }

            @Override
            public Condition path(Condition.Operator operator, String rhs) {
                throw new SelectorNotSupportedException(OriginNode.this, "path");
            }

            @Override
            public Condition uri(String value) {
                throw new SelectorNotSupportedException(OriginNode.this, "uri");
            }
        };
    }
}
