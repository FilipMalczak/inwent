package com.github.filipmalczak.inwent.impl.search.context.node.selector;

import com.github.filipmalczak.inwent.impl.search.context.node.Node;
import com.github.filipmalczak.inwent.impl.search.sql.Condition;
import lombok.Value;

@Value
public class NoSelectors implements Selectors {
    Node context;

    @Override
    public Condition id(String id){
        throw new SelectorNotSupportedException(context, "id");
    }

    @Override
    public Condition name(Condition.Operator operator, String rhs) {
        throw new SelectorNotSupportedException(context, "name");
    }

    @Override
    public Condition path(Condition.Operator operator, String rhs) {
        throw new SelectorNotSupportedException(context, "path");
    }

    @Override
    public Condition uri(String value) {
        throw new SelectorNotSupportedException(context, "uri");
    }
}
