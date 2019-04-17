package com.pky.smartselling.service;

import com.pky.smartselling.domain.employee.ActiveStatus;
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
    public Employee register(Employee registerEmployee) {
        Employee employee = employeeRepository.findByInviteCodeAndActiveStatus(registerEmployee.getInviteCode(), ActiveStatus.READY).orElseThrow(() -> new NotFoundDataException("invite code"));

        employee.setEmail(registerEmployee.getEmail());
        employee.setPassword(registerEmployee.getPassword());
        employee.setActiveStatus(ActiveStatus.ACTIVE);

        return employee;
    }

}