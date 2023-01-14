package com.github.filipmalczak.inwent.impl.common.visitor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class GenericRecordVisitor {
    static Map<String, VisitorTemplate> typeVisitors = new HashMap<>();

    private sealed interface VisitorTemplate {
        void exec(Callback callback, Object subject);
    }

    private record RecordStep(String name, Function getter) implements VisitorTemplate {

        @Override
        @SneakyThrows
        public void exec(Callback callback, Object subject) {
            var r = (Record) getter.apply(subject);
            var accumulator = callback.beforeChild(subject, name, r);
            if (r != null) { //todo quickfix; maybe another callback method for this case?
                visitor(r.getClass()).exec(callback, r);
            }
            callback.afterChild(subject, name, r, accumulator);
        }
    }

    private record ValueStep(String name, Function getter) implements VisitorTemplate {

        @Override
        @SneakyThrows
        public void exec(Callback callback, Object subject) {
            var val = getter.apply(subject);
            callback.onValue(subject, name, val);
        }

    }
    private record CollectionStep(String name, Function getter) implements VisitorTemplate {

        @Override
        @SneakyThrows
        public void exec(Callback callback, Object subject) {
            var c = (Collection) getter.apply(subject);
            var accumulator = callback.beforeCollection(subject, name, c);
            for (var o: c){
                makeStep(null, x -> o, NodeType.of(o.getClass())).exec(callback, c);
            }
            callback.afterCollection(subject, name, c, accumulator);
        }
    }

    private record MapStep(String name, Function getter) implements VisitorTemplate {

            @Override
            @SneakyThrows
            public void exec(Callback callback, Object subject) {
                var m = (Map) getter.apply(subject);
                var accumulator = callback.beforeMap(subject, name, m);
                for (var k: m.keySet()){
                    var v = m.get(k);
                    makeStep(null, x -> v, NodeType.of(v.getClass())).exec(callback, m);
                }
                callback.afterMap(subject, name, m, accumulator);
            }
        }

    private record PreparedTypeVisitor(
        List<VisitorTemplate> steps
    ) implements VisitorTemplate {
        public void exec(Callback callback, Object subject){
            for (var s: steps) {
                s.exec(callback, subject);
            }
        }

    }

    Callback callback;

    public <R extends Record> void visit(R value){
        var clazz = value.getClass();
        var visitor = visitor(clazz);
        makeStep("", x -> value, NodeType.RECORD).exec(callback, value);
    }

    private static VisitorTemplate visitor(Class clazz){
        String name = clazz.getCanonicalName();
        var result = typeVisitors.getOrDefault(name, null);
        if (result == null){
            result = makeVisitor(clazz);
            typeVisitors.put(name, result);
        }
        return result;
    }

    @SneakyThrows
    private static Object safeInvoke(Method method, Object object){
        return method.invoke(object);
    }

    @SneakyThrows
    private static Function getter(Class clazz, String name){
        var m = clazz.getMethod(name, new Class[0]);
        return x -> safeInvoke(m, x); //todo microoptimization
    }

    private enum NodeType { VALUE, RECORD, COLLECTION, MAP;
        public static NodeType of(Class clazz){
            //todo make a switch
            return clazz.isRecord() ?
                NodeType.RECORD :
                (
                    Collection.class.isAssignableFrom(clazz) ?
                        NodeType.COLLECTION :
                        (
                            Map.class.isAssignableFrom(clazz) ?
                                NodeType.MAP :
                                NodeType.VALUE
                        )
                );
        }
    };

    private static VisitorTemplate makeStep(String name, Function getter, NodeType type){
        return switch (type) {
            case RECORD -> new RecordStep(name, getter);
            case VALUE -> new ValueStep(name, getter);
            case COLLECTION -> new CollectionStep(name, getter);
            case MAP -> new MapStep(name, getter);
        };
    }
    private static VisitorTemplate makeVisitor(Class clazz){
        var steps = Stream
            .of(clazz.getDeclaredFields())
            .map(Field::getName)
            .map(name -> makeStep(name, getter(clazz, name), NodeType.of(clazz)))
            .toList();
        return new PreparedTypeVisitor(steps);
    }
}
