package com.drzewiecki.security.component;

import com.auth0.jwt.algorithms.Algorithm;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class JwtTokenConfig {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_COOKIE_NAME = "token";
    public static final String PARTNER_CLAIM_NAME = "partner";

    public static Algorithm getJwtSignAlgorithm(String secret) {
        return Algorithm.HMAC512(secret.getBytes());
    }
}
