package com.pky.smartselling.domain.estimate;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.SheetDetail;
import com.pky.smartselling.domain.customer.Customer;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "estimate_sheet")
public class EstimateSheet extends Auditable {

    @Id
    @Column(name = "estimate_sheet_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long estimateSheetNo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_no")
    Customer customer;

    @OneToMany(cascade= CascadeType.PERSIST, mappedBy="sheet")
    Collection<EstimateDetail> estimateDetaills;

}

