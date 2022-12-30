package com.github.fmd.backend.impl;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static java.util.Arrays.asList;

@Configuration
@PropertySource("classpath:/META-INF/build-info.properties")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpringDocCustomization {
    static final String ADMIN_HEADER = "X-Inwent-Admin-Secret";
    static final String TOKEN_HEADER = "X-Inwent-Access-Token";

    @Value("${spring.application.name:Incognito app who has unloving developers}")
    String name;

    @Value("${build.version:N/A}")
    String buildVersion;

    @Value("${api.version:N/A}")
    String apiVersion;

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
            .info(
                new Info()
                    .title(name)
                    .version("build: "+buildVersion+", api: v"+apiVersion)
            )
            .components(
                new Components()
                    .addSecuritySchemes("adminSecret",
                        new SecurityScheme()
                            .type(SecurityScheme.Type.APIKEY)
                            .in(SecurityScheme.In.HEADER)
                            .name("X-Inwent-Admin-Secret")
                    )
                    .addSecuritySchemes("accessToken",
                        new SecurityScheme()
                            .type(SecurityScheme.Type.APIKEY)
                            .in(SecurityScheme.In.HEADER)
                            .name("X-Inwent-Access-Token")
                    )
                    .addResponses(
                        "AdminUnauthorized",
                        new ApiResponse()
                            .description("Admin Secret is missing")
                    )
                    .addResponses(
                        "UserUnauthorized",
                        new ApiResponse()
                            .description("Access Token is missing")
                    )
            );
//            .security(
//                asList(
//                    new SecurityRequirement().addList("adminSecret", "/api/vAlpha/tag")
////                    new SecurityRequirement().addList("accessToken")
//                )
//            );
    }

}
