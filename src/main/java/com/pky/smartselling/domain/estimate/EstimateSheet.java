package com.pky.smartselling.domain.estimate;

import com.pky.smartselling.domain.customer.Customer;
import com.pky.smartselling.domain.employee.Employee;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class EstimateSheet {

    @Id
    @Column(name = "estimate_sheet_no")
    @GeneratedValue
    Long estimateSheetNo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "assigned_employee_no")
    Employee assignedEmployee;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_no")
    Customer customer;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="estimateSheet")
    Collection<EstimateDetail> estimateDetails;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}

