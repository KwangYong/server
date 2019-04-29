package com.pky.smartselling.service;

import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.domain.department.Department;
import com.pky.smartselling.repository.DepartmentRepository;
import com.pky.smartselling.util.ExceptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Transactional
    public Department addDepartment(Department willDepartment) {

        Optional.of(willDepartment.getCompany()).orElseThrow(() -> new IllegalArgumentException("Required company"));


        Optional.ofNullable(willDepartment.getParentDepartment()).ifPresent( v -> {
            Optional.ofNullable(v.getDepartmentNo()).orElseThrow(IllegalArgumentException::new);
            Optional<Department>  parentDepartment = findById(v.getDepartmentNo());
            parentDepartment.orElseThrow(ExceptionUtil.createNotFoundData("Department", v.getDepartmentNo()));

            if(!parentDepartment.equals(willDepartment.getCompany())) {
                throw new IllegalArgumentException("Wrong Parent Company No");
            }

        });
        return departmentRepository.save(willDepartment);
    }

    @Transactional(readOnly = true)
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Department> findByAll(Long companyNo) {
        Company company = new Company();
        company.setCompanyNo(companyNo);
        return departmentRepository.findAllByCompanyAndParentDepartmentIsNull(company);
    }


}
