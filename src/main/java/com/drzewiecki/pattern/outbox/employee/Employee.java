package com.drzewiecki.pattern.outbox.employee;

import lombok.Data;

/**
 * Employee to be processed by other microservice
 */

public class Employee {

    public Long id;
    public String name;
    public String lastName;
    public String position;

}
