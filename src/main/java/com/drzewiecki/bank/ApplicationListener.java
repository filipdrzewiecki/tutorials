package com.drzewiecki.bank;

import com.drzewiecki.bank.entity.Customer;
import com.drzewiecki.bank.entity.BankAccount;
import com.drzewiecki.bank.entity.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationListener {

    private final EntityManager em;

    @Transactional
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Bank bank = Bank.builder()
                .name("Santander")
                .bankUid("0000001A")
                .build();
        em.persist(bank);

        Customer customer = Customer.builder()
                .customerUid("00000003A")
                .name("Magdalena")
                .lastName("Bladowska")
                .build();
        em.persist(customer);

        BankAccount bankAccount = BankAccount.builder()
                .accountUid("0002A")
                .money(BigDecimal.TEN)
                .bank(bank)
                .customer(customer)
                .build();
        em.persist(bankAccount);

    }



}
