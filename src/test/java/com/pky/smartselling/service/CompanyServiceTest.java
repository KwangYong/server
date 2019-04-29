package com.pky.smartselling.service;

import static org.mockito.Mockito.*;

import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.exception.NotFoundDataException;
import com.pky.smartselling.repository.CompanyRepository;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.BDDMockito.*;

import java.util.Optional;

public class CompanyServiceTest {

    CompanyService companyService;

    @Before
    public void before() {
        companyService = spy(new CompanyService(mock(CompanyRepository.class)));
    }


    @Test(expected= NotFoundDataException.class)
    public void shouldTrowNotFoundExceptionWhenUpdate() {

        Company company = new Company();
        company.setCompanyNo(1L);
        given(companyService.findById(company.getCompanyNo())).willReturn(Optional.empty());

        companyService.updateCompany(company);


    }




}
