package com.pky.smartselling.domain.customer;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.domain.sheet.Sheet;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_no")
    Long customerNo;

    @ManyToOne(optional=false)
    @JoinColumn(name="company_no")
    Company company;

    @ManyToOne
    @JoinColumn(name="parent_customer_no")
    Customer parentCustomer;

    @OneToMany(mappedBy="parentCustomer")
    List<Customer> children;

    @Column
    String customerOwnerName;

    @Column
    String customerCompanyName;

    @Column
    String fax;

    @Column
    String phone;

    @Column
    String tel;

    @Column
    String businessLicenseNumber;

    @Column
    String address;

    @Column
    BigDecimal deposit; //선수금

    @Column
    BigDecimal receivable; //미수금

    @Column
    BigDecimal receipts; //가수금




}
