package com.pky.smartselling.domain.department;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.company.Company;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Department extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_no")
    Long departmentNo;

    @Column(nullable = false)
    String name;

    @ManyToOne(optional=false)
    @JoinColumn(name="company_no")
    Company company;

    @ManyToOne
    @JoinColumn(name="parent_department_no")
    Department parentDepartment;

    @OneToMany(mappedBy="parentDepartment")
    List<Department> children;

}
