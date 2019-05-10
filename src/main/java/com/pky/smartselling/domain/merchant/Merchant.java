package com.pky.smartselling.domain.merchant;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.company.Company;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "merchant")
public class Merchant extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_no")
    Long customerNo;

    @ManyToOne(optional=false)
    @JoinColumn(name="company_no")
    Company company;

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
