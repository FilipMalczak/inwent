package com.github.filipmalczak.inwent.impl.common;

import com.github.filipmalczak.inwent.impl.common.exceptions.AlreadyExistsException;
import com.github.filipmalczak.inwent.impl.common.exceptions.MissingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ServerWebExchange;

@ControllerAdvice
public class Handlers {
    //spec says that multiple headers are allowed as long as semantics are the same as if there were single
    // header with comma-separated list; thus, name of the header should be plural, as it may contain a list,
    // and ultimately does (even if its broken down to multiple header lines in transport)

    @ExceptionHandler(MissingException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handle(MissingException exception, ServerWebExchange exchange){
        String headerName = "X-Inwent-"+exception.getEntity()+"-Not-Found-"+exception.getSearchTerm()+"s";
        var headers = exchange.getResponse().getHeaders();
        for (var val: exception.getSearchValues()) {
            headers.add(headerName, val);
        }
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void handle(AlreadyExistsException exception, ServerWebExchange exchange){
        String headerName = "X-Inwent-"+exception.getEntity()+"-Already-Exists-"+exception.getSearchTerm();
        var headers = exchange.getResponse().getHeaders();
        headers.add(headerName, exception.getSearchValue());
    }
}
