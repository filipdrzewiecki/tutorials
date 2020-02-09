package com.drzewiecki.security.component;

import com.drzewiecki.security.entity.Role;
import com.drzewiecki.security.entity.User;
import com.drzewiecki.security.enums.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthenticationBuilder {
    private final HttpRequestComponent httpRequestComponent;


    public UserAuthentication buildAuthentication(User user, String token) {
        final List<Role> roles = user.getRoles().stream()
                .filter(role -> Roles.contains(role.getRoleName()))
                .collect(Collectors.toList());

        final Set<GrantedAuthority> authorities = roles
                .stream()
                .map(role -> "ROLE_" + role.getRoleName())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return UserAuthentication.builder()
                .authorities(authorities)
                .employeeUid(user.getEmployeeUid())
                .token(token)
                .userIP(httpRequestComponent.getClientIpAddress())
                .user(user)
                .isAuthenticated(true)
                .userId(user.getId())
                .userName(user.getUserName())
                .build();
    }
}