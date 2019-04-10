package com.pky.smartselling.domain.article;

import com.pky.smartselling.converter.LocalDateTimePersistenceConverter;
import com.pky.smartselling.domain.estimate.EstimateDetail;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
public class Article {

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

    @CreatedDate
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
