package com.example.tffsjavarestapi.models.dtos.errors;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateExceptionDTO {
    private String message;
    private String src;
}
