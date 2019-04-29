package com.pky.smartselling.controller.admin.dto;

import com.pky.smartselling.domain.company.CompanyStatus;
import com.pky.smartselling.util.HashIdsUtil;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AdminCompanyDto {

    @ApiModel("AdminCompanyDto")
    @Data
    public static class Request {
        Long companyId;
        String companyName;
        CompanyStatus status;
    }

    @ApiModel("AdminCompanyDto")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        String companyId;


        public void setCompanyId(String companyId) {
            this.companyId = companyId;
        }
    }
}
