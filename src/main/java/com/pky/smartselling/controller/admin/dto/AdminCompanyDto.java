package com.pky.smartselling.controller.admin.dto;

import com.pky.smartselling.domain.company.CompanyStatus;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

public class AdminCompanyDto {

    @ApiModel("AdminCompanyDto")
    @Data
    public static class Request {
        Long companyNo;
        String companyName;
        CompanyStatus status;
    }

    @ApiModel("AdminCompanyDto")
    @Data
    @AllArgsConstructor
    public static class Response {
        Long companyNo;
    }
}
