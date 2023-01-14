package com.github.filipmalczak.inwent.impl.search.context;

import com.github.filipmalczak.inwent.impl.search.context.node.Node;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InvalidTransitionException extends RuntimeException {
    Class<? extends Node> from;
    Class<? extends Node> to;

    public InvalidTransitionException(Class<? extends Node> from, Class<? extends Node> to) {
        super("Cannot transition from "+from.getSimpleName()+" to "+to.getSimpleName());
        this.from = from;
        this.to = to;
    }
}
