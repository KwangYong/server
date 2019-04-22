package com.pky.smartselling.domain.deliverySheet;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.SheetDetail;
import com.pky.smartselling.domain.customer.Customer;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "delivery_sheet")
public class DeliverySheet extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_sheet_no")
    Long deliverySheetNo;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="customer_no")
    Customer customer;

    @OneToMany(cascade= CascadeType.PERSIST, mappedBy="sheet")
    Collection<DeliveryDetail> deliveryDetails;

}
