package com.drzewiecki.security.repository;

import com.drzewiecki.security.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeUid(String employeeUid);
}
