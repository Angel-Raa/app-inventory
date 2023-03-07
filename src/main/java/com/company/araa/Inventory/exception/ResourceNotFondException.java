package com.company.araa.Inventory.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFondException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    private Object fieldName;

    public ResourceNotFondException(String message, Object fieldName) {
        this.message = message;
        this.fieldName = fieldName;
    }
}
