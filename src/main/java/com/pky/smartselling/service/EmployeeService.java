package com.pky.smartselling.service;

import com.pky.smartselling.domain.employee.EmployeeActiveStatus;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.repository.EmployeeRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class EmployeeService implements UserDetailsService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.employeeRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not found"));
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
    public Employee addTemporaryEmployee(Employee registerEmployee) {
        return employeeRepository.save(registerEmployee);
    }

}