package com.drzewiecki.security.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class NewEmployeeForm {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;
}
