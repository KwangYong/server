package com.pky.smartselling.domain.sheet;

import com.pky.smartselling.domain.article.Article;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "sheet_detail")
public class SheetDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sheet_detail_no")
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
    @JoinColumn(name = "sheet_no")
    Sheet sheet;
}
