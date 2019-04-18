package com.pky.smartselling.controller.admin;

import com.pky.smartselling.controller.admin.dto.AdminAddDepartmentDto;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.service.CompanyService;
import com.pky.smartselling.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return ResponseEntity.ok(new AdminAddDepartmentDto.Response(
                departmentService.addDepartment(
                        companyService.findById(dto.getCompanyNo()).orElseThrow(() -> new NotFoundDataException("company no")),
                        dto.getParentDepartmentNo(),
                        dto.getDepartmentName())));
    }
}
