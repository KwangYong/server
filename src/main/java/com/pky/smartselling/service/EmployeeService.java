package com.pky.smartselling.service;

import com.google.firebase.auth.FirebaseToken;
import com.pky.smartselling.domain.employee.EmployeeActiveStatus;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.repository.EmployeeRepository;
import com.pky.smartselling.util.ExceptionUtil;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class EmployeeService  {

    private EmployeeRepository employeeRepository;


    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<Employee> findByEmailByStatus(String uid, EmployeeActiveStatus employeeActiveStatus) {
        return employeeRepository.findByEmail(uid).filter(e -> e.getEmployeeActiveStatus() == employeeActiveStatus);
    }
    public Optional<Employee> findByFirebaseUid(String uid) {
        return employeeRepository.findByFirebaseUid(uid);
    }

    @Transactional
    public Employee updateEmail(Employee registerEmployee) {
        Employee employee = employeeRepository.findById(registerEmployee.getEmployeeNo()).filter(e -> e.getEmployeeActiveStatus() == EmployeeActiveStatus.READY).orElseThrow(() -> new NotFoundDataException("invite code"));

        employee.setEmail(registerEmployee.getEmail());
        employee.setPassword(registerEmployee.getPassword());
        employee.setEmployeeActiveStatus(EmployeeActiveStatus.ACTIVE);

        return employee;
    }

    @Transactional
    public Employee addEmployee(String email) {
        Employee employee = new Employee();
        employee.setEmail(email);
        employee.setEmployeeActiveStatus(EmployeeActiveStatus.READY);
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee updateMatchFirebaseUid(FirebaseToken firebaseToken) {
        Employee employee = findByEmailByStatus(firebaseToken.getEmail(), EmployeeActiveStatus.READY).orElseThrow(ExceptionUtil.createNotFoundData("email", firebaseToken.getEmail()));
        employee.setFirebaseUid(firebaseToken.getUid());
        return employee;
    }

}