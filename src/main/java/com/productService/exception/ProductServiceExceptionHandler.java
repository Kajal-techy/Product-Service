package com.productService.exception;

import com.productService.model.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ProductServiceExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ExceptionResponse> notFoundException(NotFoundException exception) {
        log.info("Entering ProductServiceExceptionHandler.notFoundException with parameter exception {}.", exception);
        return ResponseEntity.badRequest().body(ExceptionResponse.builder().message(exception.getMessage()).errorCode(400).description(exception.toString()).build());
    }

    @ExceptionHandler(value = DependencyFailureException.class)
    public ResponseEntity<ExceptionResponse> notFoundException(DependencyFailureException exception) {
        log.info("Entering ProductServiceExceptionHandler.dependencyFailureException with parameter exception {}.", exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionResponse.builder().message(exception.getMessage()).errorCode(500).description(exception.toString()).build());
    }
}
