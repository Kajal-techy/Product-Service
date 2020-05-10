package com.productService.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ProductServiceExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<NotFoundException> notFoundException(NotFoundException exception) {
        log.info("Entering ProductServiceExceptionHandler.notFoundException with parameter exception {}.", exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(value = DependencyFailureException.class)
    public ResponseEntity<DependencyFailureException> dependencyFailureException(DependencyFailureException exception) {
        log.info("Entering ProductServiceExceptionHandler.dependencyFailureException with parameter exception {}.", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
    }
}
