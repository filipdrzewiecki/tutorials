package com.drzewiecki.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {

    @NotBlank
    private String login;

    @NotBlank
    @ToString.Exclude
    private String password;
}
