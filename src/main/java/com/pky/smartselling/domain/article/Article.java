package com.pky.smartselling.domain.article;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.estimate.EstimateDetail;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Article extends Auditable {

    @Id
    @Column(name ="article_no")
    @GeneratedValue
    Long articleNo;

    @Column(name = "article_name")
    String articleName;

    @Column(name = "unit_price")
    BigDecimal unitPrice;

    @Column
    BigDecimal price;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="article")
    Collection<EstimateDetail> estimateDetails;

}
