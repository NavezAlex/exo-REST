package com.example.tffsjavarestapi.models.dtos.jwt;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponse implements Serializable {
    private final String token;
}
