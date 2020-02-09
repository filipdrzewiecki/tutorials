package com.drzewiecki.security.enums;

import java.util.Arrays;

public enum Roles {
    EMPLOYEE, ADMIN;

    public static boolean contains(String roleName) {
        return Arrays.stream(Roles.values())
                .map(Enum::name)
                .anyMatch(roleName::equals);
    }
}