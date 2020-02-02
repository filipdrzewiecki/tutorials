package com.drzewiecki.bank.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class NewCustomerForm {

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;
}
