package com.pky.smartselling.domain.company;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.department.Department;
import com.pky.smartselling.domain.estimate.EstimateSheet;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
public class Company extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_no")
    Long companyNo;

    @Column(name = "company_name", nullable = false)
    String companyName;

    @Column(name = "company_status", nullable = false)
    @Enumerated(EnumType.STRING)
    CompanyStatus companyStatus;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    Collection<Department> departments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    Collection<EstimateSheet> estimateSheets;

}
