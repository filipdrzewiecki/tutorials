package com.drzewiecki.bank.repository;

import com.drzewiecki.bank.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<Bank, Long> {

    Optional<Bank> findByBankUid(String uid);
}
