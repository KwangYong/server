package com.pky.smartselling.controller.admin.dto;

import com.pky.smartselling.controller.api.dto.AddDepartmentDto;
import com.pky.smartselling.domain.department.Department;
import com.pky.smartselling.util.ModelMapperUtil;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

public class AdminAddDepartmentDto {
    @ApiModel("AdminAddDepartmentDto")
    @Data
    public static class Request extends AddDepartmentDto.Request {
        String companyId;
    }

    @ApiModel("AdminAddDepartmentDto")
    public static class Response {

        public Response(String departmentId) {

        }
    }
    @ApiModel("AdminAddDepartmentDto")
    public static class ResponseList {

        List<AddDepartmentDto.Request> departments;
        public ResponseList (List<Department> departments) {
            ModelMapperUtil.MODEL_MAPPER.map(departments,this.departments);
        }
    }
}
