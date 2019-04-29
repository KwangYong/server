package com.pky.smartselling.domain.company;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.customer.Customer;
import com.pky.smartselling.domain.department.Department;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.domain.sheet.Sheet;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "company")
@ToString
public class Company extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_no")
    Long companyNo;

    @Column(name = "company_name", nullable = false)
    String companyName;

    @Column
    String businessLicenseNumber;

    @Column
    String address;

    @Column(name = "company_status", nullable = false)
    @Enumerated(EnumType.STRING)
    CompanyStatus companyStatus;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "company")
    Collection<Department> departments;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "company")
    Collection<Customer> customers;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "company")
    Collection<Sheet> sheets;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "company")
    Collection<Employee> employees;
}
