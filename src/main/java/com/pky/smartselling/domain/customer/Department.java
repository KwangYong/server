package com.pky.smartselling.domain.customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @Column(name = "department_no")
    Long departmentNo;

    @Column(nullable = false)
    String name;

    @ManyToOne(optional=false)
    @JoinColumn(name="customer_no")
    Customer customer;

    @ManyToOne
    @JoinColumn(name="parent_department_no")
    Department parentDepartment;

    @OneToMany(mappedBy="parentDepartment")
    List<Department> children;


}
