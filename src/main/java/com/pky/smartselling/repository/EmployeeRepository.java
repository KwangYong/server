package com.pky.smartselling.repository;

import com.pky.smartselling.domain.employee.EmployeeActiveStatus;
import com.pky.smartselling.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(@Param("email") String email);
    Optional<Employee> findByFirebaseUid(@Param("firebaseUid") String uid);

}
