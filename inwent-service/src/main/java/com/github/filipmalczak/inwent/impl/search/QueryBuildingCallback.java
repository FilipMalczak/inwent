package com.github.filipmalczak.inwent.impl.search;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;
import com.github.filipmalczak.inwent.api.model.search.query.spec.*;
import com.github.filipmalczak.inwent.impl.common.visitor.Callback;
import com.github.filipmalczak.inwent.impl.search.context.TranscriptionContext;
import com.github.filipmalczak.inwent.impl.search.context.node.*;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.BiConsumer;

import static java.util.Arrays.asList;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Slf4j
public class QueryBuildingCallback implements Callback {

    //todo it doesnt necessary need to be a predicate to cause a transition... or does it?
    private record TransitionDefinition<QueryElement extends Predicate, NodeType extends Node>(
        Class<QueryElement> queried,
        Class<NodeType> transisitonedTo
    ){};

    private record ActionDefinition<QueryElement>(Class<QueryElement> queried,
    BiConsumer<Selectors, QueryElement> action){}

    static List<TransitionDefinition> TRANSITIONS = asList(
        new TransitionDefinition(TagPredicate.class, TagNode.class),
        new TransitionDefinition(NamespacePredicate.class, NamespaceNode.class),
        new TransitionDefinition(OriginPredicate.class, OriginNode.class),
        new TransitionDefinition(ContentPredicate.class, ContentNode.class),
        new TransitionDefinition(ParentPredicate.class, ParentNode.class)
    );

    static List<ActionDefinition> ACTIONS = asList(
        new ActionDefinition<>(IdLiteral.class, (s, l) -> s.id(l.id().toString())),
        new ActionDefinition<>(NamePredicate.class, (s, p) -> {
            var namePred = p.name();
            if (namePred instanceof StringValueLiteral){
                s.name(Condition.Operator.EQUALS, ((StringValueLiteral) namePred).value());
            } else if (namePred instanceof RegexLiteral){
                s.name(Condition.Operator.MATCHES, ((RegexLiteral) namePred).regex()); //todo wrap in ''?
            } else {
                throw new IllegalStateException(); //todo
                //todo: all/any/not
            }
        }),
        new ActionDefinition<>(PathPredicate.class, (s, p) -> {
            var pathPred = p.path();
            if (pathPred instanceof StringValueLiteral){
                s.path(Condition.Operator.EQUALS, ((StringValueLiteral) pathPred).value());
            } else if (pathPred instanceof RegexLiteral){
                s.path(Condition.Operator.MATCHES, ((RegexLiteral) pathPred).regex()); //todo wrap in ''?
            } else {
                throw new IllegalStateException(); //todo
                //todo: all/any/not
            }
        }),
        new ActionDefinition<>(URILiteral.class, (s, u) -> s.uri(u.uri().toString())),
        new ActionDefinition<>(URLLiteral.class, (s, u) -> s.url(u.url().toString()))
    );

    static Class<? extends Scope> scopeFor(ScopeSpec spec){
        if (spec instanceof AllSpec)
            return All.class;
        if (spec instanceof AnySpec)
            return Any.class;
        if (spec instanceof NotSpec)
            return Not.class;
        throw new IllegalStateException(); //todo

    }

    TranscriptionContext context;

    @Override
    public Object beforeChild(Object owner, String field, Record value) {
        log.debug("Before "+"["+field+"] "+value+" @"+owner);
        if (value instanceof ScopeSpec) {
            var s = scopeFor((ScopeSpec) value);
            log.debug("Opening scope "+s);
            context.open(s);
        } else {
            boolean isTransition = false;
            boolean isAction = false;
            for (var transDef : TRANSITIONS) {
                if (transDef.queried().isInstance(value)) {
                    log.debug("Entering "+transDef.transisitonedTo);
                    context.enter(transDef.transisitonedTo());
                    isTransition = true;
                    break;
                }
            }
            if (!isTransition) {
                for (var actionDef : ACTIONS) {
                    if (actionDef.queried().isInstance(value)) {
                        log.debug("Taking action caused by "+actionDef.queried());
                        actionDef.action()
                            .accept(
                                context.selectors(),
                                value
                            );
                        isAction = true;
                        break;
                    }
                }
            }
            //fixme: introduce ignored? because it would crap out on stuff like RegexLiteral
//        if (!(isTransition || isAction)) {
//            throw new NotImplementedException("Unknown query element: "+owner); //todo
//        }
        }
        return Callback.super.beforeChild(owner, field, value);
    }

    @Override
    public void afterChild(Object owner, String field, Record value, Object accumulator) {
        log.debug("Before "+"["+field+"] "+value+" @"+owner);
        if (value instanceof ScopeSpec) {
            var s = scopeFor((ScopeSpec) value);
            log.debug("Closing "+s);
            context.close(s);
        } else {
            for (var transDef : TRANSITIONS) {
                if (transDef.queried().isInstance(value)) {
                    log.debug("Exiting "+transDef.transisitonedTo());
                    context.exit(transDef.transisitonedTo());
                    break;
                }
            }
        }
        Callback.super.afterChild(owner, field, value, accumulator);
    }
}
