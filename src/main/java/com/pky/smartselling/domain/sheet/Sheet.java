package com.pky.smartselling.domain.sheet;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.company.Company;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "sheet")
public class Sheet extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sheet_no")
    Long sheetNo;

    @OneToMany(cascade= CascadeType.PERSIST, mappedBy="sheet")
    Collection<SheetDetail> details;

    @ManyToOne(optional=false)
    @JoinColumn(name="company_no")
    Company company;

    @Column
    @Enumerated(EnumType.STRING)
    SheetType sheetType;

}
