package com.pky.smartselling;

import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.domain.company.CompanyStatus;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.domain.employee.EmployeeActiveStatus;
import com.pky.smartselling.domain.employee.EmployeeType;
import com.pky.smartselling.repository.CompanyRepository;
import com.pky.smartselling.repository.MerchantRepository;
import com.pky.smartselling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class TestInitCommandRunner implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    MerchantRepository merchantRepository;


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setFirebaseUid("4GwMqiDuUVdTAk4ryzZo7GSzTn63");
        employee.setEmail("pky1030@gmail.com");
        employee.setEmployeeActiveStatus(EmployeeActiveStatus.READY);
        employee.setEmployeeType(EmployeeType.ADMIN);
        employeeRepository.save(employee);

        Company company = new Company();
        company.setCompanyStatus(CompanyStatus.ACTIVE);
        company.setCompanyName("test");
        companyRepository.save(company);
    }
}
