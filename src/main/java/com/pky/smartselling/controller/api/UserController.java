package com.pky.smartselling.controller.api;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.pky.smartselling.configuration.constant.HttpRequestAttributes;
import com.pky.smartselling.controller.api.dto.EmployeeDto;
import com.pky.smartselling.controller.api.dto.MyselfDto;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.service.FirebaseService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/user/")
@RestController
public class UserController {
    @Autowired
    FirebaseService firebaseService;

    @GetMapping("myself")
    public ResponseEntity<EmployeeDto.Response> myself(@RequestAttribute(HttpRequestAttributes.EMPLOYEE)Employee employee) throws FirebaseAuthException {

        return ResponseEntity.ok(new EmployeeDto.Response(employee));
    }

}
