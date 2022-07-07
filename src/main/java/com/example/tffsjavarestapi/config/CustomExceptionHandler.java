package com.example.tffsjavarestapi.config;

import com.example.tffsjavarestapi.exceptions.CrudException;
import com.example.tffsjavarestapi.exceptions.NotFoundException;
import com.example.tffsjavarestapi.models.dtos.CrudExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {CrudException.class})
    public CrudExceptionDTO handleCrudException(CrudException e) {
        return CrudExceptionDTO.builder()
                .src(e.getSrc())
                .message(e.getMessage())
                .errors(e.getErrors())
                .build();
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public NotFoundException handleNotFoundException(NotFoundException e) {
        return e;
    }
}
