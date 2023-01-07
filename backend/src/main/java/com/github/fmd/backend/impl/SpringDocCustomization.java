package com.github.fmd.backend.impl;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.fmd.backend.api.security.AdminAPI.addSecurity;

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

    @SneakyThrows
    private static String readResource(String path){
        var resource = new ClassPathResource(path);
        String model = null;
        try (var is = resource.getInputStream()) {
             return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private static String joinChapters(String... chapters){
        return Stream.of(chapters).map(x -> "#"+x).collect(Collectors.joining("\n\n"));
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
            .info(
                new Info()
                    .title(name)
                    .description(
                        joinChapters(
                            readResource("docs/ABOUT.md"),
                            readResource("docs/API-STABILITY.md"),
                            readResource("docs/DATA-MODEL.md")
                        )
                    )
                    .version("build: "+buildVersion+", api: v"+apiVersion)
            )
            .components(
                addSecurity(new Components())
            );
    }

}
