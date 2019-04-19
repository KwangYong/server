package com.pky.smartselling.domain.employee;

import com.pky.smartselling.domain.Auditable;
import com.pky.smartselling.domain.department.Department;
import com.pky.smartselling.domain.estimate.EstimateSheet;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
public class Employee extends Auditable implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long employeeNo;

    @Column
    String email;

    @Column
    String password;

    @Column(name = "active_status")
    @Enumerated(EnumType.STRING)
    EmployeeActiveStatus employeeActiveStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type", nullable = false)
    EmployeeType employeeType;

    @ManyToOne
    @JoinColumn(name="department_no")
    Department department;

    @CreatedDate
    @Column(name = "created_at")
    LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(employeeType.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
