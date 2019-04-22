package com.pky.smartselling.domain.deliverySheet;

import com.pky.smartselling.domain.SheetDetail;
import com.pky.smartselling.domain.article.Article;
import com.pky.smartselling.domain.estimate.EstimateSheet;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "delivery_detail")
@AssociationOverrides({
        @AssociationOverride(name = "sheet",
                joinColumns = @JoinColumn(referencedColumnName = "delivery_sheet_no")),
})
@AttributeOverrides({
        @AttributeOverride(name = "sheetDetailNo" , column = @Column(name = "delivery_detail_no")),
})
public class DeliveryDetail extends SheetDetail<DeliverySheet> {

}
