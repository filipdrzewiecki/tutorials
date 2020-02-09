package com.drzewiecki;

import com.drzewiecki.bank.service.BankAccountService;
import com.drzewiecki.bank.service.BankService;
import com.drzewiecki.bank.service.CustomerService;
import com.drzewiecki.security.Service.EmployeeService;
import com.drzewiecki.security.Service.UserService;
import com.drzewiecki.security.entity.Employee;
import com.drzewiecki.security.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApplicationListener {

    private final EntityManager em;
    private final CustomerService customerService;
    private final BankService bankService;
    private final BankAccountService bankAccountService;
    private final UserService userService;
    private final EmployeeService employeeService;

    @Transactional
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //empty implementation, used to make operations ad hoc

    }
}
