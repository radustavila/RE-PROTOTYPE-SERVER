package com.frizerii.protorype.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    public ResponseEntity<MessageErrorResponse> handleException(CustomException exc) {
        exc.printStackTrace();
        MessageErrorResponse errorResponse = new MessageErrorResponse(exc.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<MessageErrorResponse> handleException(RuntimeException exc) {
        exc.printStackTrace();
        MessageErrorResponse errorResponse = new MessageErrorResponse("Internal Server Error");
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

