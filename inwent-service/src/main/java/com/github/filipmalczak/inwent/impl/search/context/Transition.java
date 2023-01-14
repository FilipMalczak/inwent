package com.github.filipmalczak.inwent.impl.search.context;

import com.github.filipmalczak.inwent.impl.search.context.node.Node;
import com.github.filipmalczak.inwent.impl.search.sql.Condition;
import com.github.filipmalczak.inwent.impl.search.sql.Explicit;

/**
 * (from) --via.left--------via.right-> (to)
 *
 * e.g.
 *
 * (Hit) --tag_id------------------id-> (Tag)
 */
public record Transition(
    Node from,
    ColumnPair via,
    Node to
) {
    public Condition condition(){
        return new Explicit(
            from.table().column(via.left()),
            Condition.Operator.EQUALS,
            to.table().column(via.right())
        );
    }
}
