package com.github.filipmalczak.inwent.impl.search.context;

import com.github.filipmalczak.inwent.impl.search.context.node.Node;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.Condition;
import com.github.filipmalczak.inwent.impl.search.sql.Joinable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.lang.reflect.Proxy;
import java.util.*;

import static org.valid4j.Assertive.require;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TranscriptionContext {
    Stack<Node> stack = new Stack<>();
    @NonFinal
    Joinable visitedTables = null;
    @NonFinal
    @Getter Set<Condition> criteria = new HashSet<>();

    public TranscriptionContext(Node start) {
        stack.push(start);
        visitedTables = start.table();
        require(visitedTables != null);
    }

    private Node currentNode(){
        try {
            return stack.peek();
        } catch (EmptyStackException e){
            return null; //todo dedicated exception; this basically means deferred NPE
        }
    }

    public void enter(Class<? extends Node> node){
        var transition = currentNode().transitionTo(node);
        var newContext = transition.to();
        stack.push(newContext);
        var t = newContext.table();
        if (t != null && !visitedTables.knownTables().contains(t)) {
            visitedTables = visitedTables.join(t, transition.condition());
        }
    }
    
    public void exit(Class<? extends Node> node){
        if (!node.isInstance(currentNode()))
            throw new RuntimeException(); //todo dedicated
        stack.pop();
    }

    public Selectors selectors(){
        Selectors nodeSelectors = currentNode().selectors();
        return (Selectors) Proxy
            .newProxyInstance(
                Selectors.class.getClassLoader(), //todo to static field
                new Class[] { Selectors.class },
                (proxy, method, args) -> {
                    var out = method.invoke(nodeSelectors, args);
                    noteDown((Condition) out);
                    return out;
                }
            );
    }

    public Joinable getSearchSpace(){
        return visitedTables;
    }


    private void noteDown(Condition condition){
        //todo selectors should return condition + optional join
        criteria.add(condition);
    }
}
