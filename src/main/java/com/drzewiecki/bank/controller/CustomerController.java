package com.drzewiecki.bank.controller;

import com.drzewiecki.bank.dto.NewCustomerForm;
import com.drzewiecki.bank.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.drzewiecki.bank.service.CustomerService;

import java.util.List;


@RestController
@RequestMapping("/rest/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addNewCustomer(@RequestBody @Validated final NewCustomerForm form) {
        final Customer customer = customerService.createNew(form);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @GetMapping("/{customerUid}")
    public Customer getCustomer(@PathVariable("customerUid") final String customerUid) {
        return customerService.getByUid(customerUid);
    }

    @GetMapping()
    public List<Customer> getAllCustomers() {
        return customerService.getAll();
    }
}
