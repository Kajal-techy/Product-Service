package com.productService.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties({ "stackTrace", "cause", "message", "suppressed", "localizedMessage"})
public class NotFoundException extends RuntimeException {

    int errorCode = 404;
    String errorMessage;

    public NotFoundException(String message) {
        super(message);
        this.errorMessage = message;
    }
}
