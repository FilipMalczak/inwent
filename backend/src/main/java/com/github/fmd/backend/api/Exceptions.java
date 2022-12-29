package com.github.fmd.backend.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

@ControllerAdvice
public class Exceptions {
    //these need to be handled as a server errors, so its best to leave them unhandled
    public static class ReactiveStreamException extends RuntimeException {}
}
