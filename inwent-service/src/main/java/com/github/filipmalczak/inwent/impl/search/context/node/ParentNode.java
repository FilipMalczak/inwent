package com.github.filipmalczak.inwent.impl.search.context.node;

import com.github.filipmalczak.inwent.impl.search.context.ColumnPair;
import com.github.filipmalczak.inwent.impl.search.context.InvalidTransitionException;
import com.github.filipmalczak.inwent.impl.search.context.Transition;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.NoSelectors;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.QueriedTable;

public record ParentNode(int parentCount, QueriedTable table) implements Node {

    @Override
    public Selectors selectors() {
        return new NoSelectors(this);
    }

    @Override
    public Transition transitionTo(Class<? extends Node> target) {
        if (TagNode.class.equals(target))
            //the count is incremented as soon as we enter parent node (on tag->parent transition)
            //but the join happens here
            return new Transition(this, new ColumnPair("parent_id", "id"), new TagNode(parentCount));
        throw new InvalidTransitionException(HitNode.class, target);
    }
}
