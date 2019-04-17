package com.pky.smartselling.controller.department;

import com.pky.smartselling.controller.department.dto.AddDepartmentDto;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department/")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public  ResponseEntity addDepartment(@AuthenticationPrincipal Employee userDetails,
                                         @Valid  AddDepartmentDto.Request dto){

        return ResponseEntity.ok(new AddDepartmentDto.Response(
                departmentService.addDepartment(
                        userDetails.getDepartment().getCompany(),
                        dto.getParentDepartmentNo(),
                        dto.getDepartmentName())));
    }
}
