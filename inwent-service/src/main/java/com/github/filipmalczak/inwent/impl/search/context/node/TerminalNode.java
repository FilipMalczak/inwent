package com.github.filipmalczak.inwent.impl.search.context.node;

import com.github.filipmalczak.inwent.impl.search.context.InvalidTransitionException;
import com.github.filipmalczak.inwent.impl.search.context.Transition;

/**
 * Terminal nodes only expose selectors - you cannot transition to other nodes from them.
 */
public interface TerminalNode extends Node {
    default Transition transitionTo(Class<? extends Node> target){
        throw new InvalidTransitionException(this.getClass(), target);
    }
}
