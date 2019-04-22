package com.pky.smartselling.domain.estimate;

import com.pky.smartselling.domain.SheetDetail;
import com.pky.smartselling.domain.deliverySheet.DeliverySheet;

import javax.persistence.*;
import java.lang.annotation.Target;

@Entity
@Table(name = "estimate_detail")
@AssociationOverrides({
        @AssociationOverride(name = "sheet",
                joinColumns = @JoinColumn(referencedColumnName = "estimate_sheet_no"))
})
@AttributeOverrides({
        @AttributeOverride(name = "sheetDetailNo" , column = @Column(name = "estimate_detail_no"))
})
public class EstimateDetail extends SheetDetail<EstimateSheet> {
}
