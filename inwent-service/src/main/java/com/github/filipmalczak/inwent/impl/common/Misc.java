package com.github.filipmalczak.inwent.impl.common;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class Misc {
    public static String capitalize(String txt) {
        return txt.substring(0, 1).toUpperCase() + txt.substring(1);
    }

    public static String quoted(String txt){
        return "\""+txt+"\"";
    }

    public static <T> Set<T> asSet(T... vals){
        return Stream.of(vals).collect(toSet());
    }

    public static Function<String, String> parenthesised = x -> "("+x+")";
}
