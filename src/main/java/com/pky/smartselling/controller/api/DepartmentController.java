package com.pky.smartselling.controller.api;

import com.pky.smartselling.controller.api.dto.AddDepartmentDto;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/department/")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public  ResponseEntity addDepartment(@AuthenticationPrincipal Employee userDetails,
                                         @RequestBody @Valid AddDepartmentDto.Request dto){

        return ResponseEntity.ok(new AddDepartmentDto.Response(
                departmentService.addDepartment(
                        userDetails.getDepartment().getCompany(),
                        dto.getParentDepartmentNo(),
                        dto.getDepartmentName())));
    }
}
