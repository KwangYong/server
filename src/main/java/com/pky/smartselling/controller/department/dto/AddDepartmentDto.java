package com.pky.smartselling.controller.department.dto;

import com.pky.smartselling.domain.department.Department;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public class AddDepartmentDto {

    @Data
    public static class Request {
        Optional<Long> parentDepartmentNo;
        @NotBlank
        String departmentName;
    }

    @Data
    public static class Response {
        Long departmentNo;

        public Response(Department department) {
            this.departmentNo = department.getDepartmentNo();
        }
    }
}
