package com.pky.smartselling.controller.api.dto;

import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.util.HashIdsUtil;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;

public class EmployeeDto {
    @ApiModel("EmployeeDto")
    @Data
    public static class Request {

    }

    @ApiModel("EmployeeDto")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {

        String employeeId;
        String companyName;
        String companyId;
        String departmentName;
        String departmentId;
        String email;
        Long createdAt;
        public Response(Employee employee) {
            employeeId = HashIdsUtil.encode(employee.getEmployeeNo());
            companyId = HashIdsUtil.encode(employee.getDepartment().or().getCompany();
            companyName = employee.getDepartment().getCompany().getCompanyName();
            departmentName = employee.getDepartment().getDepartmentName();
            departmentId = HashIdsUtil.encode(employee.getDepartment().getDepartmentNo());
            email = employee.getEmail();
            createdAt = employee.getCreatedAt().toEpochSecond(ZoneOffset.UTC);
        }
    }
}
