package com.drzewiecki.bank.service;

import com.drzewiecki.bank.dto.NewCustomerForm;
import com.drzewiecki.bank.entity.Customer;
import com.drzewiecki.bank.interfaces.ServiceOrm;
import com.drzewiecki.bank.repository.CustomerRepository;
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
public class CustomerService implements ServiceOrm<Customer, NewCustomerForm> {

    private final CustomerRepository customerRepository;

    @Override
    public Customer createNew(NewCustomerForm form) {
        Customer customer = assembleFromForm(form);
        return customerRepository.save(customer);
    }

    @Override
    public Customer getByUid(String uid) {
        return customerRepository.findByCustomerUid(uid).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Customer getById(long id) {
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    private Customer assembleFromForm(NewCustomerForm form) {
       return Customer.builder()
               .name(form.getName())
               .lastName(form.getLastName())
               .customerUid(generateUid(Customer.class))
               .build();
    }
}
