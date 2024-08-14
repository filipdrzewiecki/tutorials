package com.drzewiecki.pattern.outbox.order;


import com.drzewiecki.pattern.outbox.employee.Employee;
import org.springframework.stereotype.Component;

/**
 * Test mock client to imitate integration with other microservice
 */
@Component
public class IamMockClient {

    public Employee sendEmployee(Employee employee) {
        return employee;
    }
}
