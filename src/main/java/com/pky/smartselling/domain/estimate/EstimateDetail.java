package com.pky.smartselling.domain.estimate;

import com.pky.smartselling.domain.article.Article;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class EstimateDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long estimateDetailNo;

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
    @JoinColumn(name = "estimate_sheet_no", referencedColumnName = "estimate_sheet_no", nullable = false)
    EstimateSheet estimateSheet;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
