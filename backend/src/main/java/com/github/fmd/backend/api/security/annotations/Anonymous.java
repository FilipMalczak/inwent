package com.github.fmd.backend.api.security.annotations;

import java.lang.annotation.*;

/**
 * Purely documentational. May be useful for aspects or smth.
 * */
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Anonymous {
}
