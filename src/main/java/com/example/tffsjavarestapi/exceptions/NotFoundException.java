package com.example.tffsjavarestapi.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NotFoundException extends RuntimeException {
    private HttpStatus status;
    private String src;
    private Object finders;

    public NotFoundException(HttpStatus status, String src, Object finders, String message) {
        super(message);
        this.status = status;
        this.src = src;
        this.finders = finders;
    }
}
