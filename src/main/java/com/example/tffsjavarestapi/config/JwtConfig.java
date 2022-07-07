package com.example.tffsjavarestapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    private String secret;
    private int expireAt;
}
