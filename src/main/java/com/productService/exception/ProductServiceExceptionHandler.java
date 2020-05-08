package com.productService.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ProductServiceExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> notFoundException(NotFoundException exception) {
        log.info("Entering ProductServiceExceptionHandler.notFoundException with parameter exception {}.", exception);
        return ResponseEntity.badRequest().body(exception.toString());
    }
}
