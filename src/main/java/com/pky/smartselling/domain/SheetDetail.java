package com.pky.smartselling.domain;

import com.pky.smartselling.domain.article.Article;
import com.pky.smartselling.domain.estimate.EstimateSheet;

import javax.persistence.*;
import java.math.BigDecimal;

@MappedSuperclass
public abstract class SheetDetail <T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_no")
    Long sheetDetailNo;

    @Column(name = "unit_price")
    BigDecimal unitPrice;

    @Column
    BigDecimal amount;

    @Column
    BigDecimal qty;

    @Column
    String description;

    @ManyToOne
    @JoinColumn(name = "article_no")
    Article article;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sheet_no", referencedColumnName = "sheet_no")
    T sheet;
}
