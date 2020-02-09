package com.drzewiecki.security.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class NewUserForm {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String repeatedPassword;

    private boolean doPasswordsMatch() {
        return password.equals(repeatedPassword);
    }
}
