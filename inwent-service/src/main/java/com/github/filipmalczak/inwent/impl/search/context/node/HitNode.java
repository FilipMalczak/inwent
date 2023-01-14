package com.github.filipmalczak.inwent.impl.search.context.node;

import com.github.filipmalczak.inwent.impl.search.context.ColumnPair;
import com.github.filipmalczak.inwent.impl.search.context.InvalidTransitionException;
import com.github.filipmalczak.inwent.impl.search.context.Transition;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.NoSelectors;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.QueriedTable;

public class HitNode implements Node {
    //fixme table names are duplicated on XData DTOs too; extract to constants
    private static final QueriedTable HIT_TABLE = new QueriedTable("hit", "h");

    @Override
    public QueriedTable table() {
        return HIT_TABLE;
    }

    @Override
    public Selectors selectors() {
        return new NoSelectors(this);
    }

    @Override
    public Transition transitionTo(Class<? extends Node> target) {
        if (TagNode.class.equals(target))
            return new Transition(this, new ColumnPair("tag_id", "id"), new TagNode(0));
        if (ContentNode.class.equals(target))
            return new Transition(this, new ColumnPair("content_id", "id"), new ContentNode());
        if (OriginNode.class.equals(target))
            return new Transition(this, new ColumnPair("origin_id", "id"), new OriginNode());
        throw new InvalidTransitionException(HitNode.class, target);
    }
}
