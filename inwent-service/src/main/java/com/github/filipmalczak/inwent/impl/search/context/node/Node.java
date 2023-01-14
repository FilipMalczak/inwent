package com.github.filipmalczak.inwent.impl.search.context.node;

import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.context.Transition;
import com.github.filipmalczak.inwent.impl.search.sql.QueriedTable;

public interface Node {
    QueriedTable table();

    /**
     * Selectors here should just return sql stuff; context intercepts these calls to compose the whole query.
     * @return
     */
    Selectors selectors();

    Transition transitionTo(Class<? extends Node> target);

}
