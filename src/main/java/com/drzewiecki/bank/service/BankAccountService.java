package com.drzewiecki.bank.service;

import com.drzewiecki.bank.dto.NewBankAccountForm;
import com.drzewiecki.bank.entity.Bank;
import com.drzewiecki.bank.entity.BankAccount;
import com.drzewiecki.bank.entity.Customer;
import com.drzewiecki.bank.interfaces.ServiceOrm;
import com.drzewiecki.bank.repository.BankAccountRepository;
import com.drzewiecki.bank.repository.BankRepository;
import com.drzewiecki.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;

import static com.drzewiecki.bank.service.UidService.generateUid;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class BankAccountService implements ServiceOrm<BankAccount, NewBankAccountForm> {

    private final BankAccountRepository bankAccountRepository;
    private final BankRepository bankRepository;
    private final CustomerRepository customerRepository;

    @Override
    @Transactional
    public BankAccount createNew(NewBankAccountForm form) {
        BankAccount bankAccount = assembleFromForm(form);
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    @Transactional(readOnly = true)
    public BankAccount getByUid(String uid) {
        return bankAccountRepository.findByAccountUid(uid).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public BankAccount getById(long id) {
        return bankAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }

    private BankAccount assembleFromForm(NewBankAccountForm form) {
        Bank bank = bankRepository.findByBankUid(form.getBankUid())
                .orElseThrow(EntityNotFoundException::new);
        Customer customer = customerRepository.findByCustomerUid(form.getBankUid())
                .orElseThrow(EntityNotFoundException::new);

        return BankAccount.builder()
                .bank(bank)
                .money(BigDecimal.ZERO)
                .customer(customer)
                .accountUid(generateUid(BankAccount.class))
                .build();
    }

}
