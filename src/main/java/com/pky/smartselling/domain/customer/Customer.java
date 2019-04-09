package com.pky.smartselling.domain.customer;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "customer_no")
    Long customerNo;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="customer")
    List<Department> departments;
}
