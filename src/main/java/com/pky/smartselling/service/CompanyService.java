package com.pky.smartselling.service;

import com.pky.smartselling.domain.company.CompanyStatus;
import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.repository.CompanyRepository;
import com.pky.smartselling.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Transactional
    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }
    @Transactional
    public Company updateCompany(Company updateData) {
        final Company findCompany = findById(updateData.getCompanyNo()).orElseThrow(() -> new NotFoundDataException(String.format("company id %d", updateData.getCompanyNo())));
        ModelMapperUtil.MODEL_MAPPER.map(updateData, findCompany);
        return findCompany;
    }

    public Optional<Company> findById(Long companyNo){
        return companyRepository.findById(companyNo);
    }
}
