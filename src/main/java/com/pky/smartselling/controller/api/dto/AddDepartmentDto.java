package com.pky.smartselling.controller.api.dto;

import com.pky.smartselling.domain.department.Department;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class AddDepartmentDto {

    @ApiModel("AddDepartmentDto")
    @Data
    public static class Request {

        Optional<Long> parentDepartmentNo = Optional.empty();

        @NotBlank
        String departmentName;

    }
    @ApiModel("AddDepartmentDto")
    @Data
    public static class Response {
        Long departmentNo;

        public Response(Department department) {
            this.departmentNo = department.getDepartmentNo();
        }
    }
}
