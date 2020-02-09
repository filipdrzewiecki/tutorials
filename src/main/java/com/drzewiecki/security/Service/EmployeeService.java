package com.drzewiecki.security.Service;

import com.drzewiecki.bank.entity.Customer;
import com.drzewiecki.bank.interfaces.ServiceOrm;
import com.drzewiecki.security.dto.NewEmployeeForm;
import com.drzewiecki.security.entity.Employee;
import com.drzewiecki.security.repository.EmployeeRepository;
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
public class EmployeeService implements ServiceOrm<Employee, NewEmployeeForm> {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createNew(NewEmployeeForm form) {
        Employee employee = assembleFromForm(form);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getByUid(String uid) {
        return employeeRepository.findByEmployeeUid(uid).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Employee getById(long id) {
        return employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    private Employee assembleFromForm(NewEmployeeForm form) {
        return Employee.builder()
                .name(form.getName())
                .lastName(form.getLastName())
                .employeeUid(generateUid(Customer.class))
                .build();
    }
}
