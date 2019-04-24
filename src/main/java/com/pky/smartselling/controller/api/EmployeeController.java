package com.pky.smartselling.controller.api;

import com.pky.smartselling.configuration.security.JwtTokenProvider;
import com.pky.smartselling.controller.api.dto.AddTemporaryEmployeeDto;
import com.pky.smartselling.controller.api.dto.UpdateEmailEmployeeDto;
import com.pky.smartselling.controller.api.dto.SignInDto;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.domain.employee.EmployeeType;
import com.pky.smartselling.service.DepartmentService;
import com.pky.smartselling.service.EmployeeService;
import com.pky.smartselling.util.HashIdsUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    HashIdsUtil hashIdsUtil;

    @PutMapping("{employeeNo}/email")
    public ResponseEntity<Void> updaterEmail(@PathVariable("employeeNo") String employeeNo, @RequestBody @Valid UpdateEmailEmployeeDto.Request request) {
        final Employee copyEmployee = new Employee();
        BeanUtils.copyProperties(request,  copyEmployee);
        copyEmployee.setEmployeeNo(hashIdsUtil.decode(employeeNo));

        employeeService.updateEmail(copyEmployee);

        return ResponseEntity.ok(null);
    }

    @PostMapping("temporary")
    public ResponseEntity<AddTemporaryEmployeeDto.Response> addTemporary(@AuthenticationPrincipal Employee userDetails,
                                                                              @RequestBody @Valid AddTemporaryEmployeeDto.Request request) {
        final Employee copiedEmployee = new Employee();
        copiedEmployee.setEmployeeType(EmployeeType.USER);

        String inviteCode = hashIdsUtil.encode(employeeService.addTemporaryEmployee(copiedEmployee).getEmployeeNo());
        return ResponseEntity.ok(new AddTemporaryEmployeeDto.Response(inviteCode));
    }

    @PostMapping("signIn")
    public ResponseEntity signIn(@RequestBody @Valid SignInDto.Request request) {
        try {
            String username = request.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));

            String token = jwtTokenProvider.createToken(username);
            return ResponseEntity.ok(new SignInDto.Response("Bearer "+ token));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

}
