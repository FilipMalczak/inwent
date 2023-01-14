package com.github.filipmalczak.inwent.impl.search;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Predicate;
import com.github.filipmalczak.inwent.api.model.search.query.spec.*;
import com.github.filipmalczak.inwent.impl.common.visitor.Callback;
import com.github.filipmalczak.inwent.impl.search.context.TranscriptionContext;
import com.github.filipmalczak.inwent.impl.search.context.node.*;
import com.github.filipmalczak.inwent.impl.search.context.node.selector.Selectors;
import com.github.filipmalczak.inwent.impl.search.sql.Condition;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.function.BiConsumer;

import static java.util.Arrays.asList;
import static org.valid4j.Assertive.require;

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

    TranscriptionContext context;

    @Override
    public Object beforeChild(Object owner, String field, Record value) {
        log.debug("Before "+owner+" :: "+field+" -> "+value);
        boolean isTransition = false;
        boolean isAction = false;
        for (var transDef: TRANSITIONS){
            if (transDef.queried().isInstance(owner)){
                context.enter(transDef.transisitonedTo());
                isTransition = true;
                break;
            }
        }
        if (!isTransition) {
            for (var actionDef: ACTIONS){
                if (actionDef.queried().isInstance(owner)) {
                    actionDef.action()
                        .accept(
                            context.selectors(),
                            owner
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
        return Callback.super.beforeChild(owner, field, value);
    }

    @Override
    public void afterChild(Object owner, String field, Record value, Object accumulator) {
        for (var transDef: TRANSITIONS){
            if (transDef.queried().isInstance(owner)){
                context.exit(transDef.transisitonedTo());
                break;
            }
        }
        Callback.super.afterChild(owner, field, value, accumulator);
    }
}
