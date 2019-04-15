package com.pky.smartselling.domain.employee;

import com.pky.smartselling.domain.customer.Department;
import com.pky.smartselling.domain.estimate.EstimateSheet;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Data
@Entity
public class Employee implements UserDetails {

    @Id
    @GeneratedValue
    Long employeeNo;

    @Column
    String email;

    @Column
    String password;

    @Column(name ="invite_code")
    String inviteCode;

    @Column(name = "active_status")
    @Enumerated(EnumType.STRING)
    ActiveStatus activeStatus;

    @ManyToOne
    @JoinColumn(name="department_no")
    Department department;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="assignedEmployee")
    Collection<EstimateSheet> estimateSheets;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
