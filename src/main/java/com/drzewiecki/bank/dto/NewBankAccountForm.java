package com.drzewiecki.bank.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class NewBankAccountForm {

    @NotBlank
    private String bankUid;

    @NotBlank
    private String customerUid;


}
