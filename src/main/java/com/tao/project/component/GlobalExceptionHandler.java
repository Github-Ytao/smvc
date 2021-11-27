package com.tao.project.component;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author YangTao
 * @date 2021-11-27 14:40
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity exceptionHandler(RuntimeException e) {
        if (e instanceof NullPointerException) {
            return new ResponseEntity(e.getMessage(), HttpStatus.ACCEPTED);
        }
        return null;
    }
}
