package com.moby.dashboard.exception.global;

import com.moby.dashboard.exception.EmptyException;
import com.moby.dashboard.exception.NotExistIdException;
import com.moby.dashboard.exception.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<ResponseMessage> emptyExceptionsHandler(EmptyException exception){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }
    @ExceptionHandler(NotExistIdException.class)
    public ResponseEntity<ResponseMessage> notFoundTypeIdExceptionHandler(NotExistIdException exception){
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> exceptions(Exception exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }
}
