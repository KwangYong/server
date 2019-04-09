package com.pky.smartselling.repository;

import com.pky.smartselling.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByInviteCodeAAndActiveStatusIsREADY(String inviteCode);
}
