package com.pky.smartselling.domain.department;

import com.pky.smartselling.domain.company.Company;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Department {

    @Id
    @GeneratedValue
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

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
