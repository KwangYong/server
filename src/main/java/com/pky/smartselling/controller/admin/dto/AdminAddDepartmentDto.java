package com.pky.smartselling.controller.admin.dto;

import com.pky.smartselling.controller.api.dto.AddDepartmentDto;
import com.pky.smartselling.domain.department.Department;
import io.swagger.annotations.ApiModel;
import lombok.Data;

public class AdminAddDepartmentDto {
    @ApiModel("AdminAddDepartmentDto")
    @Data
    public static class Request extends AddDepartmentDto.Request {
        long companyNo;
    }

    @ApiModel("AdminAddDepartmentDto")
    public static class Response extends AddDepartmentDto.Response {

        public Response(Department companyNo) {
            super((companyNo));
        }
    }
}
