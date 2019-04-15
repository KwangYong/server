package com.pky.smartselling.service;

import com.pky.smartselling.domain.employee.ActiveStatus;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public Employee register(Employee registerEmployee) {
        Employee employee = employeeRepository.findByInviteCodeAndActiveStatus(registerEmployee.getInviteCode(), ActiveStatus.READY).orElseThrow(() -> new NotFoundDataException("invite code"));

        employee.setEmail(registerEmployee.getEmail());
        employee.setPassword(registerEmployee.getPassword());
        employee.setActiveStatus(ActiveStatus.ACTIVE);

        return employee;
    }

    public Optional<Employee> findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }


}
