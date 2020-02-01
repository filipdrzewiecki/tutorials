package com.drzewiecki.bank.controller;

import com.drzewiecki.bank.dto.NewBankForm;
import com.drzewiecki.bank.entity.Bank;
import com.drzewiecki.bank.service.BankService;
import com.drzewiecki.bank.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @PostMapping
    public ResponseEntity<Bank> addNewBank(@RequestBody @Validated final NewBankForm form) {
        final Bank Bank = bankService.createNew(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(Bank);
    }

    @GetMapping("/{BankUid}")
    public Bank getBank(@PathVariable("BankUid") final String BankUid) {
        return bankService.getByUid(BankUid);
    }

    @GetMapping()
    public List<Bank> getAllBanks() {
        return bankService.getAll();
    }
}
