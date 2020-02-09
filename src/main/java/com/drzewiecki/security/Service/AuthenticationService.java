package com.drzewiecki.security.Service;

import com.drzewiecki.security.component.JwtTokenBuilder;
import com.drzewiecki.security.component.UserAuthentication;
import com.drzewiecki.security.dto.LoginForm;
import com.drzewiecki.security.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtTokenBuilder jwtTokenBuilder;

    public String createToken(LoginForm loginForm) {
        log.info("Generating token for user {}", loginForm.getLogin());
        final User user = userService.findByUserNameAndPlainTextPassword(loginForm.getLogin(), loginForm.getPassword())
                .orElseThrow(() -> new BadCredentialsException("Bad credentials"));

        log.info("Token successfully generated for user {}", loginForm.getLogin());
        return jwtTokenBuilder.createToken(user);
    }

    public boolean hasAuthGivenPartnerUid(UserAuthentication authentication, String partnerUid) {
        return authentication.getEmployeeUid().equals(partnerUid);
    }
}