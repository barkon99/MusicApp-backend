package com.konew.musicapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserAlreadySavedResourcesHandler
{
    @ExceptionHandler(UserAlreadySavedResourcesException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String UserAlreadySavedResourcesHandler(UserAlreadySavedResourcesException exc)
    {
        return exc.getMessage();
    }
}
