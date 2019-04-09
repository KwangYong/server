package com.pky.smartselling.service;

import com.pky.smartselling.domain.employee.ActiveStatus;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public void register(Employee registerEmployee) {
        Employee findEmployee = employeeRepository.findByInviteCodeAAndActiveStatusIsREADY(registerEmployee.getInviteCode()).orElseThrow(() -> new NotFoundDataException("invite code"));

        findEmployee.setEmail(registerEmployee.getEmail());
        findEmployee.setPassword(registerEmployee.getPassword());
        findEmployee.setActiveStatus(ActiveStatus.ACTIVE);
    }




}
