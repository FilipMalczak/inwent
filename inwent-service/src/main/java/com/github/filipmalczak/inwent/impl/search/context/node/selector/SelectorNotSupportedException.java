package com.github.filipmalczak.inwent.impl.search.context.node.selector;

import com.github.filipmalczak.inwent.impl.search.context.node.Node;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class SelectorNotSupportedException extends RuntimeException{
    Node contextNode;
    String selectorName;

    public SelectorNotSupportedException(Node contextNode, String selectorName) {
        super("Selector "+selectorName+" is not supported in context of "+contextNode);
        this.contextNode = contextNode;
        this.selectorName = selectorName;
    }
}
