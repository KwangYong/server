package com.pky.smartselling.domain.employee;

import com.pky.smartselling.domain.customer.Department;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue
    Long employeeNo;

    @Column
    String email;

    @Column
    String password;

    @Column
    String inviteCode;

    @Column(name = "active_status")
    @Enumerated(EnumType.STRING)
    ActiveStatus activeStatus;

    @ManyToOne
    @JoinColumn(name="department_no")
    Department department;
}
