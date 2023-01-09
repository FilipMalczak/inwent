package com.github.filipmalczak.inwent.impl.common;

import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URL;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Values {
    @Value("${api.version}")
    String apiVersion;

    @Autowired
    ReactiveWebServerApplicationContext server;

    @SneakyThrows
    public URI uri(String s){
        return new URI(s);
    }

    @SneakyThrows
    public URL url(String s){
        return new URL(s);
    }

    public int port(){
        return server.getWebServer().getPort();
    }

    /**
     *
     * @param postVersionPath starts with slash, e.g. "/location"
     */
    public String endpoint(String hostname, String postVersionPath){
        return hostname+":"+port()+"api/v"+apiVersion+postVersionPath;
    }
}
