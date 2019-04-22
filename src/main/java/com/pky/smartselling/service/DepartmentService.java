package com.pky.smartselling.service;

import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.domain.department.Department;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    public Department addDepartment(Company company, Optional<Long> parentDepartmentNo, String departmentName) {

        Department saveDepartment = new Department();
        saveDepartment.setName(departmentName);

        parentDepartmentNo.ifPresent( v -> saveDepartment.setParentDepartment(departmentRepository.findById(v).orElseThrow(() -> new NotFoundDataException(String.format("parent department id %d", v)))));
        saveDepartment.setCompany(company);

        return departmentRepository.save(saveDepartment);
    }

    @Transactional(readOnly = true)
    public Optional<Department> findById(Long id){
        return departmentRepository.findById(id);
    }


}
