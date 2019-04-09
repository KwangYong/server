package com.pky.smartselling.domain.customer;

import org.springframework.data.annotation.Id;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {

    @Id
    @Column(name = "customer_no")
    Long customerNo;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="customer")
    List<Department> departments;
}
