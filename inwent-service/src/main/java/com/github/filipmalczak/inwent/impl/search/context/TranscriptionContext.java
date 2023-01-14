package com.github.filipmalczak.inwent.impl.search.context;

import com.github.filipmalczak.inwent.impl.search.context.node.Node;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.All;
import com.github.filipmalczak.inwent.impl.search.sql.Condition;
import com.github.filipmalczak.inwent.impl.search.sql.Joinable;
import com.github.filipmalczak.inwent.impl.search.sql.Scope;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.data.relational.core.query.Criteria;

import java.lang.reflect.Proxy;
import java.util.*;

import static org.valid4j.Assertive.require;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TranscriptionContext {


    Stack<Node> nodeStack = new Stack<>();
    Stack<Scope> scopeStack = new Stack<>();
    @NonFinal
    Joinable visitedTables = null;

    public TranscriptionContext(Node start) {
        nodeStack.push(start);
        scopeStack.push(new All(new ArrayList<>()));
        visitedTables = start.table();
        require(visitedTables != null);
    }

    private Node currentNode(){
        return nodeStack.peek();
    }

    private Scope currentScope(){
        return scopeStack.peek();
    }

    public void enter(Class<? extends Node> node){
        var transition = currentNode().transitionTo(node);
        var newContext = transition.to();
        nodeStack.push(newContext);
        var t = newContext.table();
        if (t != null && !visitedTables.knownTables().contains(t)) {
            visitedTables = visitedTables.join(t, transition.condition());
        }
    }
    
    public void exit(Class<? extends Node> node){
        if (!node.isInstance(currentNode()))
            throw new RuntimeException(); //todo dedicated
        nodeStack.pop();
    }

    @SneakyThrows
    public void open(Class<? extends Scope> scope){
        var s = scope.getConstructor(new Class[] { List.class }).newInstance(new ArrayList());
        scopeStack.push(s);
    }

    public void close(Class<? extends Scope> scope){
        if (!scope.isInstance(currentScope()))
            throw new RuntimeException(); //todo dedicated
        var popped = scopeStack.pop();
        currentScope().add(popped);
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

    public Scope getSearchScope(){
        return currentScope();
    }


    private void noteDown(Condition condition){
        //todo selectors should return condition + optional join
        currentScope().add(condition);
    }
}
