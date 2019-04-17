package com.pky.smartselling.service;

import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Optional<Company> findById(Long companyNo){
        return companyRepository.findById(companyNo);
    }
}
