package com.pky.smartselling.controller.api;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.pky.smartselling.configuration.constant.HttpRequestAttributes;
import com.pky.smartselling.controller.api.dto.AddTemporaryEmployeeDto;
import com.pky.smartselling.controller.api.dto.MyselfDto;
import com.pky.smartselling.controller.api.dto.UpdateEmailEmployeeDto;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.domain.employee.EmployeeType;
import com.pky.smartselling.service.DepartmentService;
import com.pky.smartselling.service.EmployeeService;
import com.pky.smartselling.service.FirebaseService;
import com.pky.smartselling.util.HashIdsUtil;
import com.pky.smartselling.util.ModelMapperUtil;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/employee/")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    AuthenticationManager authenticationManager;

    public ResponseEntity<Void> updaterEmail(@PathVariable("employeeNo") String employeeNo, @RequestBody @Valid UpdateEmailEmployeeDto.Request request) {
        final Employee copyEmployee = new Employee();
        BeanUtils.copyProperties(request,  copyEmployee);
        copyEmployee.setEmployeeNo(HashIdsUtil.decode(employeeNo));

        employeeService.updateEmail(copyEmployee);

        return ResponseEntity.ok(null);
    }

    @PostMapping("{email}")
    public ResponseEntity<AddTemporaryEmployeeDto.Response> addTemporary(@PathVariable("email") String email,
                                                                         @RequestBody @Valid AddTemporaryEmployeeDto.Request request) {
        final Employee copiedEmployee = new Employee();
        copiedEmployee.setEmployeeType(EmployeeType.USER);

        String inviteCode = HashIdsUtil.encode(employeeService.addEmployee(email).getEmployeeNo());
        return ResponseEntity.ok(new AddTemporaryEmployeeDto.Response(inviteCode));
    }


}
