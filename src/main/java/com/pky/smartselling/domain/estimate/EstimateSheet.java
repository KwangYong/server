package com.pky.smartselling.domain.estimate;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.domain.employee.Employee;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class EstimateSheet extends Auditable {

    @Id
    @Column(name = "estimate_sheet_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long estimateSheetNo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="company_no")
    Company company;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="estimateSheet")
    Collection<EstimateDetail> estimateDetails;

}

