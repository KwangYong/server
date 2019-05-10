package com.pky.smartselling.domain;

import com.pky.smartselling.converter.LocalDateTimePersistenceConverter;
import com.pky.smartselling.domain.employee.Employee;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Getter()
@Setter()
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable {

    @CreatedBy
    @Column(name = "created_by")
    private Long createdBy;

    @CreationTimestamp
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private Long lastModifiedBy;

    @UpdateTimestamp
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Column(name = "last_modified_at")
    private LocalDateTime lastModifiedAt;

    @Column(name = "deleted_by")
    private Long deletedBy;

    @Convert(converter = LocalDateTimePersistenceConverter.class)
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

}