package com.moby.dashboard.exception.global;

import com.moby.dashboard.exception.EmptyException;
import com.moby.dashboard.exception.NotExistIdException;
import com.moby.dashboard.exception.ResponseMessage;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyException.class)
    public ResponseEntity<ResponseMessage> emptyExceptionsHandler(EmptyException exception){
        log.error("EmptyException "+exception.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }
    @ExceptionHandler(NotExistIdException.class)
    public ResponseEntity<ResponseMessage> notFoundTypeIdExceptionHandler(NotExistIdException exception){
        log.error("NotExistIdException "+exception.getMessage());
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> exceptions(Exception exception){
        log.error("Exception "+exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseMessage.builder()
                        .message(exception.getMessage()).build());
    }
}
