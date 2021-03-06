package com.pky.smartselling.repository;

import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.domain.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByCompanyAndParentDepartmentIsNull(Company company);
}
