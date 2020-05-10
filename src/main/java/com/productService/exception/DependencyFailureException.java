package com.productService.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DependencyFailureException extends RuntimeException {

    int errorCode = 502;
    String errorMessage;

    public DependencyFailureException(String message) {
        super(message);
        this.errorMessage = message;
    }
}
