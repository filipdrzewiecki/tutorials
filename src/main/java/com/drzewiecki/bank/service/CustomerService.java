package com.drzewiecki.bank.service;

import com.drzewiecki.bank.dto.NewCustomerForm;
import com.drzewiecki.bank.entity.Customer;
import com.drzewiecki.bank.interfaces.ServiceOrm;
import com.drzewiecki.bank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional(rollbackFor = Exception.class)
@Service
@RequiredArgsConstructor
public class CustomerService implements ServiceOrm<Customer, NewCustomerForm> {

    private final CustomerRepository customerRepository;

    @Override
    public  Customer createNew(NewCustomerForm form) {
        return null;
    }

    @Override
    public Customer getByUid(String uid) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getById(long id) {
        return null;
    }
}
