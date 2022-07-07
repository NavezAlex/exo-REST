package com.example.tffsjavarestapi.models.dtos.jwt;

import lombok.Data;

import java.io.Serializable;

// {username: 'Flavian', password: 'Ovyn'}
@Data
public class JwtRequest implements Serializable {
    private String username;
    private String password;
}
