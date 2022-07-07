package com.example.tffsjavarestapi.exceptions;

import com.example.tffsjavarestapi.utils.crud.Crud;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

@Data
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class CrudException extends RuntimeException {
    private String src;
    private List<ObjectError> errors = new ArrayList<>();

    public CrudException() {

    }
    public CrudException(String src) {
        this.src = src;
    }

    public CrudException(String src, Object message, List<ObjectError> errors) {
        super(message.toString());
        this.src = src;
        if (errors != null) {
            this.errors.addAll(errors);
        }
    }
}
