package com.pky.smartselling.controller.employee;

import com.pky.smartselling.controller.employee.dto.RegisterDto;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/employee/")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public RegisterDto register(RegisterDto.Request request) {
        final Employee copyEmployee = new Employee();
        BeanUtils.copyProperties(request,  copyEmployee);

        final Employee saveEmployee = employeeService.register(copyEmployee);

        return new RegisterDto.Response();

    }





}
