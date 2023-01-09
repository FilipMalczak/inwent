package com.github.filipmalczak.inwent.impl.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

import static com.github.filipmalczak.inwent.impl.common.Misc.capitalize;
import static java.util.Arrays.asList;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class MissingException extends RuntimeException {
    String entity;
    String entities;
    List<String> ids;

    public MissingException(String entity, String entities, String id, String... ids) {
        super(
            ids.length > 0 ?
                capitalize(entities) + " with following IDs are missing: "+l(id, ids) :
                capitalize(entity)+" with following ID is missing: "+id
        );
        this.entity = entity;
        this.entities = entities;
        this.ids = l(id, ids);
    }

    private static List<String> l(String id, String... ids){
        var out = new ArrayList<String>(id.length());
        out.add(id);
        out.addAll(asList(ids));
        return out;
    }


}
