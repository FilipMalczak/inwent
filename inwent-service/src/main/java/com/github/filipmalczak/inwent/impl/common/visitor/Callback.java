package com.github.filipmalczak.inwent.impl.common.visitor;

import java.util.Collection;
import java.util.Map;

public interface Callback {
    default void onValue(Object owner, String field, Object value){}
    default void onNull(Object owner, String field){}

    default Object beforeChild(Object owner, String field, Record value) { return null; }
    default void afterChild(Object owner, String field, Record value, Object accumulator){}

    default Object beforeCollection(Object owner, String field, Collection value) { return null; }
    default void afterCollection(Object owner, String field, Collection value, Object accumulator){}

    default Object beforeMap(Object owner, String field, Map value) { return null; }
    default void afterMap(Object owner, String field, Map value, Object accumulator){}
}
