package com.pky.smartselling;

import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class TestInitCommandRunner implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {


        Employee em = new Employee();

        em.setEmail("string");
        em.setPassword(passwordEncoder.encode("string"));
        employeeRepository.save(em);
    }
}
