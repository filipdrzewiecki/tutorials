package com.drzewiecki.bank.service;

import com.drzewiecki.bank.dto.NewBankAccountForm;
import com.drzewiecki.bank.entity.BankAccount;
import com.drzewiecki.bank.interfaces.ServiceOrm;
import com.drzewiecki.bank.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class BankAccountService implements ServiceOrm<BankAccount, NewBankAccountForm> {

    private final BankAccountRepository bankAccountRepository;

    @Override
    public BankAccount createNew(NewBankAccountForm form) {
        return null;
    }

    @Override
    public BankAccount getByUid(String uid) {
        return null;
    }

    @Override
    public BankAccount getById(long id) {
        return null;
    }

    @Override
    public List<BankAccount> getAll() {
        return null;
    }
}
