package com.mccormack.controller;

import com.mccormack.exception.NonCalculableInputException;
import com.mccormack.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ NonCalculableInputException.class, MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleKnownErrors(Throwable exception) {
        log.info("Bad request caused exception: ", exception);
        return ErrorResponse.builder()
                .errorMessage("Invalid input, value must be a positive integer")
                .build();
    }

    @ExceptionHandler(NoResourceFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleInvalidPathErrors(Throwable exception) {
        log.info("User made request to invalid endpoint", exception);
        return ErrorResponse.builder()
                .errorMessage("No path found for request")
                .build();
    }

    // Not covered by tests because if I knew in advance what everything that could cause an exception
    // I'd have a handler for it
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllErrors(Throwable exception) {
        log.error("Exception handling request", exception);
        return ErrorResponse.builder()
                .errorMessage("Something went wrong, please notify admin")
                .build();
    }

}
