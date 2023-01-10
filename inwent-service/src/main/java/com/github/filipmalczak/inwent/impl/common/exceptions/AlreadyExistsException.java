package com.github.filipmalczak.inwent.impl.common.exceptions;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import static com.github.filipmalczak.inwent.impl.common.Misc.capitalize;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
public class AlreadyExistsException extends RuntimeException {
    String entity;
    String searchTerm;
    String searchValue;

    public AlreadyExistsException(String entity, String searchTerm, String searchValue) {
        super(capitalize(entity)+"Data with "+searchTerm+"='"+searchValue+"' already exists!");
        this.entity = entity;
        this.searchTerm = searchTerm;
        this.searchValue = searchValue;
    }
}
