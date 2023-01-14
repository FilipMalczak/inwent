package com.github.filipmalczak.inwent.impl.search.context.node;

import com.github.filipmalczak.inwent.impl.search.context.ColumnPair;
import com.github.filipmalczak.inwent.impl.search.context.InvalidTransitionException;
import com.github.filipmalczak.inwent.impl.search.context.Transition;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.SelectorNotSupportedException;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.*;
import lombok.Getter;
import lombok.Value;
import lombok.experimental.Accessors;

@Value
public class TagNode implements Node {
    int parentCount;

    @Accessors(fluent = true)
    @Getter(lazy = true)
    QueriedTable table = new QueriedTable("tag", "t"+parentCount);

    @Override
    public Selectors selectors() {
        return new Selectors() {
            @Override
            public Condition id(String id) {
                return new Explicit(table().column("id"), Condition.Operator.EQUALS, new SqlStr(id));
            }

            @Override
            public Condition name(Condition.Operator operator, String rhs) {
                return new Explicit(table().column("tag_name"), operator, new SqlStr(rhs));
            }

            @Override
            public Condition path(Condition.Operator operator, String rhs) {
                //todo
                throw new SelectorNotSupportedException(TagNode.this, "path");
            }

            @Override
            public Condition uri(String value) {
                throw new SelectorNotSupportedException(TagNode.this, "uri");
            }
        };
    }

    @Override
    public Transition transitionTo(Class<? extends Node> target) {
        if (NamespaceNode.class.equals(target)){
            return new Transition(this, new ColumnPair("namespace_id", "id"), new NamespaceNode(parentCount));
        }
        if (ParentNode.class.equals(target)){
            //incrementing happens here, not on the parent -> tag transition
            //but the join happens there
            return new Transition(this, null, new ParentNode(parentCount + 1, table()));
        }
        throw new InvalidTransitionException(TagNode.class, target);
    }
}
