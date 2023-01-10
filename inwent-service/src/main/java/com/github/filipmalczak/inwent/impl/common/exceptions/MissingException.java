package com.github.filipmalczak.inwent.impl.common.exceptions;

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
    String searchTerm;
    List<String> searchValues;

    public MissingException(String entity, String searchTerm, List<String> searchValues) {
        super(capitalize(entity)+"Data with following "+searchTerm+"s is missing: "+searchValues);
        this.entity = entity;
        this.searchTerm = searchTerm;
        this.searchValues = searchValues;
    }

    private static List<String> l(String id, String... ids){
        var out = new ArrayList<String>(id.length());
        out.add(id);
        out.addAll(asList(ids));
        return out;
    }


}
