package com.github.fmd.backend.impl;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/META-INF/build-info.properties")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpringDocCustomization {
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
            );
    }

}
