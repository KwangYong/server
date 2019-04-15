package com.pky.smartselling.controller.employee;

import com.pky.smartselling.configuration.security.JwtTokenProvider;
import com.pky.smartselling.controller.employee.dto.RegisterDto;
import com.pky.smartselling.controller.employee.dto.SignInDto;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/v1/employee/")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;


    @PostMapping
    public RegisterDto register(RegisterDto.Request request) {
        final Employee copyEmployee = new Employee();
        BeanUtils.copyProperties(request,  copyEmployee);

        final Employee saveEmployee = employeeService.register(copyEmployee);
        return new RegisterDto.Response();
    }

    @PostMapping("/sign")
    public ResponseEntity signIn(@RequestBody SignInDto.Request request) {
        try {
            String username = request.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, request.getPassword()));

            String token = jwtTokenProvider.createToken(username, );
            Map<Object, Object> model = new HashMap();
            model.put("username", username);
            model.put("token", token);
            return ResponseEntity.ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }




}
