package com.pky.smartselling.controller.admin;

import com.pky.smartselling.controller.admin.dto.AdminAddDepartmentDto;
import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.domain.department.Department;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.service.CompanyService;
import com.pky.smartselling.service.DepartmentService;
import com.pky.smartselling.util.HashIdsUtil;
import com.pky.smartselling.util.ModelMapperUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/admin/api/v1/department/")
@RestController
public class AdminDepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CompanyService companyService;

    @PostMapping
    public ResponseEntity addDepartment(@RequestBody @Valid AdminAddDepartmentDto.Request dto){

        Department requestSaveDepartment = new Department();

        BeanUtils.copyProperties(dto, requestSaveDepartment);

        Company company = new Company();
        company.setCompanyNo(HashIdsUtil.decode(dto.getCompanyId()));
        requestSaveDepartment.setCompany(company);

        dto.getParentDepartmentId().ifPresent(c -> {
            Department parent = new Department();
            parent.setDepartmentNo(HashIdsUtil.decode(c));
            requestSaveDepartment.setParentDepartment(parent);
        });

        departmentService.addDepartment(requestSaveDepartment);

        return ResponseEntity.ok(requestSaveDepartment);
    }

    @GetMapping
    public ResponseEntity getDepartments(String companyId) {        ;
        return ResponseEntity.ok(departmentService.findByAll(HashIdsUtil.decode(companyId)));
    }
}
