package com.github.filipmalczak.inwent.impl.common.visitor;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Slf4j
public class RecordVisitor {
    public <R extends Record> void visit(R root, Callback callback){
        log.debug("Visiting root: "+root);
        visitRecordFields(root, callback);
    }

    public void visitAnything(Object owner, String field, Object value, Callback callback){
        log.debug("Visit anything: "+owner+" :: "+field+" -> "+value);
        if (value == null){
            log.debug("Visit null: "+owner+"+ :: "+field);
            callback.onNull(owner, field);
        } else  if (value instanceof Record) {
            log.debug("Before record: "+owner+" :: "+field+" -> "+value);
            var acc = callback.beforeChild(owner, field, (Record) value);
            visitRecordFields((Record) value, callback);
            log.debug("After record: "+owner+" :: "+field+" -> "+value);
            callback.afterChild(owner, field, (Record) value, acc);
        } else if (value instanceof Collection<?>){
            log.debug("Before collection: "+owner+" :: "+field+" -> "+value);
            var acc = callback.beforeCollection(owner, field, (Collection) value);
            visitCollectionItems((Collection) value, callback);
            log.debug("After collection: "+owner+" :: "+field+" -> "+value);
            callback.afterCollection(owner, field, (Collection) value, acc);
        } else if (value instanceof Map){
            log.debug("Before map: "+owner+" :: "+field+" -> "+value);
            var acc = callback.beforeMap(owner, field, (Map) value);
            visitMapEntries((Map) value, callback);
            log.debug("After map: "+owner+" :: "+field+" -> "+value);
            callback.afterMap(owner, field, (Map) value, acc);
        } else {
            log.debug("Visit value: "+owner+" :: "+field+" -> "+value);
            callback.onValue(owner, field, value);
        }
    }

    private void visitMapEntries(Map map, Callback callback) {
        for (var k: map.keySet()){
            log.debug("Visit entry key: "+k);
            visitAnything(map, "#map-key", k, callback);
            var v = map.get(k);
            log.debug("Visit entry value: "+v);
            visitAnything(map, "#map-value", v, callback);
        }
    }

    private void visitCollectionItems(Collection collection, Callback callback) {
        for (var item: collection){
            log.debug("Visit collection item: "+item);
            visitAnything(collection, "#collection-item", item, callback);
        }
    }

    @SneakyThrows
    private <R extends Record> void visitRecordFields(R owner, Callback callback){
        var c = owner.getClass();
        for (var f: c.getDeclaredFields()){
            var fieldVal = c.getMethod(f.getName(), new Class[0]).invoke(owner);
            log.debug("Visit record field: ["+f.getName()+"] "+fieldVal);
            visitAnything(owner, f.getName(), fieldVal, callback);
        }
    }
}
