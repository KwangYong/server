package com.pky.smartselling.domain.employee;

import com.pky.smartselling.domain.customer.Customer;
import com.pky.smartselling.domain.customer.Department;

import javax.persistence.*;
import java.util.List;

public class Employee {

    @Id
    Long employeeNo;

    @Column
    String email;

    @Column
    String password;

    @Column(name = "active_status")
    @Enumerated(EnumType.STRING)
    ActiveStatus activeStatus;

    @ManyToOne
    @JoinColumn(name="department_no")
    Department department;
}
