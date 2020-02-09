package com.drzewiecki.security.component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

import static com.drzewiecki.security.component.JwtTokenConfig.TOKEN_COOKIE_NAME;
import static com.drzewiecki.security.component.JwtTokenConfig.TOKEN_PREFIX;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private final JwtTokenSettings jwtTokenSettings;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,
                                  JwtTokenSettings jwtTokenSettings) {
        super(authenticationManager);
        this.jwtTokenSettings = jwtTokenSettings;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        final String token = getToken(request);

        if (token != null && token.startsWith(TOKEN_PREFIX)) {
            try {
                final PreAuthenticatedAuthenticationToken preAuthentication = getAuthentication(token);
                final Authentication authentication = getAuthenticationManager().authenticate(preAuthentication);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                log.warn("Authentication by token failed - invalid token {}", token);
            }
        }

        chain.doFilter(request, response);
    }

    private PreAuthenticatedAuthenticationToken getAuthentication(String header) {
        final DecodedJWT token = JWT.require(JwtTokenConfig.getJwtSignAlgorithm(jwtTokenSettings.getSecret()))
                .build()
                .verify(header.replace(TOKEN_PREFIX, ""));

        if (StringUtils.isEmpty(token.getSubject())) {
            throw new BadCredentialsException("Illegal token with empty user name");
        }
        return new PreAuthenticatedAuthenticationToken(token.getSubject(), token.getToken());
    }

    private String getToken(HttpServletRequest request) {
        final String tokenHeader = request.getHeader(JwtTokenConfig.TOKEN_HEADER);
        final Cookie[] cookies = request.getCookies();

        final boolean isBearerToken = tokenHeader != null && tokenHeader.startsWith(TOKEN_PREFIX);
        if (isBearerToken || cookies == null) {
            return tokenHeader;
        }

        return Arrays.stream(cookies)
                .filter(cookie -> TOKEN_COOKIE_NAME.equals(cookie.getName()))
                .map(cookie -> TOKEN_PREFIX + cookie.getValue())
                .findAny()
                .orElse(null);
    }
}
