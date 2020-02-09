package com.drzewiecki.security.component;

import com.drzewiecki.security.Service.UserService;
import com.drzewiecki.security.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final UserService userService;
    private final AuthenticationBuilder authenticationBuilder;
    private final JwtTokenBuilder jwtTokenBuilder;

    private final static String BAD_CREDENTIALS_MESSAGE = "Bad credentials";

    private final Set<Class> supportedAuthentications = Set.of(
            UsernamePasswordAuthenticationToken.class,
            PreAuthenticatedAuthenticationToken.class
    );

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        final UserAuthentication userAuthentication = authentication instanceof UsernamePasswordAuthenticationToken
                ? authenticateByLoginAndPassword((UsernamePasswordAuthenticationToken) authentication)
                : authenticateByToken((PreAuthenticatedAuthenticationToken) authentication);
        logUserInteraction(userAuthentication);
        return userAuthentication;
    }

    private void logUserInteraction(UserAuthentication authentication) {
        MDC.put("username", authentication.getName());
        MDC.put("employee", authentication.getEmployeeUid());
        MDC.put("ip", authentication.getUserIP());
    }

    private UserAuthentication authenticateByToken(PreAuthenticatedAuthenticationToken authentication) {
        final String userName = authentication.getName();
        final String token = authentication.getCredentials().toString();
        log.info("Received token with username {}", userName);

        final User user = userService.findByUserName(userName);

        log.info("Token for username {} was valid", userName);

        return authenticationBuilder.buildAuthentication(user, token);
    }

    private UserAuthentication authenticateByLoginAndPassword(UsernamePasswordAuthenticationToken authentication) {
        final User user = userService.findByUserNameAndPlainTextPassword(authentication.getName(), authentication.getCredentials().toString())
                .orElseThrow(() -> new BadCredentialsException(BAD_CREDENTIALS_MESSAGE));

        final String token = jwtTokenBuilder.createToken(user);

        return authenticationBuilder.buildAuthentication(user, token);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return supportedAuthentications.contains(authentication);
    }
}
