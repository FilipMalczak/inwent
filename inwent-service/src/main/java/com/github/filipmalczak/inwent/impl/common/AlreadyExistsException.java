package com.github.filipmalczak.inwent.impl.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static com.github.filipmalczak.inwent.impl.common.Misc.capitalize;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class AlreadyExistsException extends RuntimeException {
    String entity;
    String id;

    public AlreadyExistsException(String entity, String id) {
        super(capitalize(entity)+" of id '"+id+"' already exists!");
        this.entity = entity;
        this.id = id;
    }
}
