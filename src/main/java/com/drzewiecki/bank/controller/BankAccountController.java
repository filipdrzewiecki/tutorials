package com.drzewiecki.bank.controller;

import com.drzewiecki.bank.dto.NewBankAccountForm;
import com.drzewiecki.bank.entity.BankAccount;
import com.drzewiecki.bank.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/bankAccount")
@RequiredArgsConstructor
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping
    public ResponseEntity<BankAccount> addNewBankAccount(@RequestBody @Validated final NewBankAccountForm form) {
        final BankAccount BankAccount = bankAccountService.createNew(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(BankAccount);
    }

    @GetMapping("/{bankAccountUid}")
    public BankAccount getBankAccount(@PathVariable("bankAccountUid") final String bankAccountUid) {
        return bankAccountService.getByUid(bankAccountUid);
    }

    @GetMapping()
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountService.getAll();
    }
}
