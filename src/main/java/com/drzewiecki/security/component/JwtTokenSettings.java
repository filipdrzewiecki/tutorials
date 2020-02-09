package com.drzewiecki.security.component;

import lombok.Data;

@Data
public class JwtTokenSettings {
    private String secret;
    private Long expirationTimeMillis;
}
