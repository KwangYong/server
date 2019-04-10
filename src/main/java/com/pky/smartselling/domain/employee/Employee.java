package com.pky.smartselling.domain.employee;

import com.pky.smartselling.converter.LocalDateTimePersistenceConverter;
import com.pky.smartselling.domain.customer.Department;
import com.pky.smartselling.domain.estimate.EstimateSheet;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

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

    @Column(name ="invite_code")
    String inviteCode;

    @Column(name = "active_status")
    @Enumerated(EnumType.STRING)
    ActiveStatus activeStatus;

    @ManyToOne
    @JoinColumn(name="department_no")
    Department department;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="assignedEmployee")
    Collection<EstimateSheet> estimateSheets;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
