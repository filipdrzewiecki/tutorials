package com.drzewiecki.pattern.outbox.employee;

import com.drzewiecki.pattern.outbox.order.OrderService;
import com.drzewiecki.pattern.outbox.order.OrderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final OrderService orderService;

    public Employee createEmployee(Employee employee) {
        orderService.createOrder(OrderType.EMPLOYEE_CREATION, employee);
        int hash = employee.hashCode();
        return employee;
    }

    public Employee updateEmployee(Long employeeId, Employee employee) {
        orderService.createOrder(OrderType.EMPLOYEE_CREATION, employeeId, employee);
        return employee;
    }

    public void deleteEmployee(Long employeeId) {
        orderService.createOrder(OrderType.EMPLOYEE_CREATION, employeeId);
    }
}
