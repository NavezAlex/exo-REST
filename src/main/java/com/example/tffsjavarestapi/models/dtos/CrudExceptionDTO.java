package com.example.tffsjavarestapi.models.dtos;

import lombok.Builder;
import lombok.Data;
import org.springframework.validation.ObjectError;

import java.util.List;

@Data
@Builder
public class CrudExceptionDTO {
    private String src;
    private String message;
    private List<ObjectError> errors;
}
