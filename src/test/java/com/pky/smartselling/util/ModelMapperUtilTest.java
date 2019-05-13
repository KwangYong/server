package com.pky.smartselling.util;

import com.pky.smartselling.controller.admin.dto.AdminCompanyDto;
import com.pky.smartselling.domain.company.Company;
import org.junit.Assert;
import org.junit.Test;

public class ModelMapperUtilTest {

    @Test
    public void shouldCompanyToAdminCompanyDtoResponse() {

        //given
        Company company = new Company();
        company.setCompanyNo(1L);

        //when
        AdminCompanyDto.Response target = ModelMapperUtil.MODEL_MAPPER.map(company, AdminCompanyDto.Response.class);

        //then
        Assert.assertNotNull(target.getCompanyId());

    }
}
