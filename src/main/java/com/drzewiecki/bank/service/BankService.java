package com.drzewiecki.bank.service;

import com.drzewiecki.bank.dto.NewBankForm;
import com.drzewiecki.bank.entity.Bank;
import com.drzewiecki.bank.interfaces.ServiceOrm;
import com.drzewiecki.bank.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static com.drzewiecki.bank.service.UidService.generateUid;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class BankService implements ServiceOrm<Bank, NewBankForm> {

    private final BankRepository bankRepository;

    @Override
    public Bank createNew(NewBankForm form) {
        Bank bank = assembleFromForm(form);
        return bankRepository.save(bank);
    }

    @Override
    public Bank getByUid(String uid) {
        return bankRepository.findByBankUid(uid).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Bank getById(long id) {
        return bankRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    private Bank assembleFromForm(NewBankForm form) {
        return Bank.builder()
                .name(form.getName())
                .bankUid(generateUid(Bank.class))
                .build();
    }

}
