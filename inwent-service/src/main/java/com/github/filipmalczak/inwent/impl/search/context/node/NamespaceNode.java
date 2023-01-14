package com.github.filipmalczak.inwent.impl.search.context.node;

import com.github.filipmalczak.inwent.impl.search.context.node.selector.SelectorNotSupportedException;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.*;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.Accessors;

import static com.github.filipmalczak.inwent.impl.search.sql.Condition.Operator.EQUALS;

@Value
public class NamespaceNode implements TerminalNode {
    int parentCount;

    @Accessors(fluent = true)
    @Getter(lazy = true)
    QueriedTable table = new QueriedTable("namespace", "n"+parentCount);

    @Override
    public Selectors selectors() {
        return new Selectors() {
            @Override
            public Condition id(String id) {
                return new Explicit(table().column("id"), EQUALS, new SqlStr(id));
            }

            @Override
            public Condition name(Condition.Operator operator, String rhs) {
                throw new SelectorNotSupportedException(NamespaceNode.this, "name");
            }

            @Override
            public Condition path(Condition.Operator operator, String rhs) {
                return new Explicit(table().column("namespace_path"), operator, new SqlStr(rhs));
            }

            @Override
            public Condition uri(String value) {
                throw new SelectorNotSupportedException(NamespaceNode.this, "uri");
            }
        };
    }
}
