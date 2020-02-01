package com.drzewiecki.bank.service;

import com.drzewiecki.bank.dto.NewBankForm;
import com.drzewiecki.bank.entity.Bank;
import com.drzewiecki.bank.interfaces.ServiceOrm;
import com.drzewiecki.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class BankService implements ServiceOrm<Bank, NewBankForm> {

    private final BankRepository bankRepository;

    @Override
    public Bank createNew(NewBankForm form) {
        return null;
    }

    @Override
    public Bank getByUid(String uid) {
        return null;
    }

    @Override
    public Bank getById(long id) {
        return null;
    }

    @Override
    public List<Bank> getAll() {
        return null;
    }
}
