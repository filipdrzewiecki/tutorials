package com.drzewiecki.bank.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class NewBankForm {

    @NotBlank
    private String name;
}
