package com.github.filipmalczak.inwent.impl.search.context.node;

import com.github.filipmalczak.inwent.impl.search.context.node.selector.SelectorNotSupportedException;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.Condition;
import com.github.filipmalczak.inwent.impl.search.sql.Condition.Operator;
import com.github.filipmalczak.inwent.impl.search.sql.Explicit;
import com.github.filipmalczak.inwent.impl.search.sql.QueriedTable;
import com.github.filipmalczak.inwent.impl.search.sql.Sql;

import static com.github.filipmalczak.inwent.impl.search.sql.Condition.Operator.EQUALS;

public class ContentNode implements TerminalNode {
    private static final QueriedTable CONTENT_TABLE = new QueriedTable("hit", "h");

    @Override
    public QueriedTable table() {
        return CONTENT_TABLE;
    }

    @Override
    public Selectors selectors() {
        return new Selectors() {
            @Override
            public Condition id(String id) {
                return new Explicit(CONTENT_TABLE.column("id"), EQUALS, new Sql(id));
            }

            @Override
            public Condition name(Operator operator, String rhs) {
                //fixme name/title???
                return new Explicit(CONTENT_TABLE.column("title"), operator, new Sql(rhs));
            }

            @Override
            public Condition path(Operator operator, String rhs) {
                throw new SelectorNotSupportedException(ContentNode.this, "path");
            }

            @Override
            public Condition uri(String value) {
                throw new SelectorNotSupportedException(ContentNode.this, "uri");
            }
        };
    }
}
