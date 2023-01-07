package com.github.filipmalczak.inwent.api.security.annotations;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@SecurityRequirement(name = "adminSecret")
@ApiResponse(responseCode = "401", ref = "AdminUnauthorized")
public @interface AdminSecret {
}
