package com.drzewiecki.security.controller;

import com.drzewiecki.security.Service.AuthenticationService;
import com.drzewiecki.security.Service.UserService;
import com.drzewiecki.security.dto.LoginForm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/createToken")
    public Map.Entry<String, String> createToken(@RequestBody @Validated LoginForm loginForm) {
        return Map.entry("token", authenticationService.createToken(loginForm));
    }


    @PreAuthorize("!isAnonymous()")
    @GetMapping
    public Authentication getAuthentication(Authentication authentication) {
        return authentication;
    }
}
