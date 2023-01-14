package com.github.filipmalczak.inwent.api.model.search.query.meta;

import java.util.List;

public interface HasCanonicalForm<T extends HasCanonicalForm> {
    T toCanonicalForm();

    static <T extends HasCanonicalForm<T>> List<T> canonical(List<T> list){
        return list.stream().map(x -> (T) x.toCanonicalForm()).toList();
    }
}
