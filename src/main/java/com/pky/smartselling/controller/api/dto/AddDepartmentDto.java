package com.pky.smartselling.controller.api.dto;

import com.pky.smartselling.domain.department.Department;
import com.pky.smartselling.util.HashIdsUtil;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class AddDepartmentDto {

    @ApiModel("AddDepartmentDto")
    @Data
    public static class Request {

        Optional<String> parentDepartmentId = Optional.empty();


        @NotBlank
        String departmentName;

    }
    @ApiModel("AddDepartmentDto")

    @AllArgsConstructor
    public static class Response {

        Long departmentId;

        public String getDepartmentId() {
            return HashIdsUtil.encode(departmentId);
        }

    }
}
