package com.pky.smartselling.domain.customer;

import com.pky.smartselling.converter.LocalDateTimePersistenceConverter;
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
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_no")
    Long customerNo;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="customer")
    Collection<Department> departments;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="customer")
    Collection<EstimateSheet> estimateSheets;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
