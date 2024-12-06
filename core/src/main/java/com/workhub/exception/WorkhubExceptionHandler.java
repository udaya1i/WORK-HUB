package com.workhub.exception;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for the Workhub project.
 * <p>
 * This class handles exceptions thrown by the application and
 * returns appropriate HTTP responses.
 * </p>
 *
 * @author udaya
 */


@RestControllerAdvice
public class WorkhubExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<Map<String, String>> handel(InvalidRequestException ex){
    Map<String, String> response = new HashMap<>();
    response.put("message", ex.getMessage());

    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
