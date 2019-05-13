package com.pky.smartselling.controller.api.dto;

import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.util.HashIdsUtil;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZoneOffset;
import java.util.Optional;

public class EmployeeDto {
    @ApiModel("EmployeeDto")
    @Data
    public static class Request {

    }

    @ApiModel("EmployeeDto")
    @Data
    public static class Response {

        String employeeId;
        String companyId;
        String companyName;
        String departmentId;
        String departmentName;
        String email;
        Long createdAt;

        public Response(Employee employee) {

            Optional.ofNullable(employee.getDepartment()).ifPresent(d -> {
                departmentId = HashIdsUtil.encode(d.getDepartmentNo());
                departmentName = d.getDepartmentName();

                Optional.ofNullable(d.getCompany()).ifPresent(c -> {
                    companyId = HashIdsUtil.encode(c.getCompanyNo());
                    companyName = c.getCompanyName();
                });
            });

            email = employee.getEmail();
            employeeId = HashIdsUtil.encode(employee.getEmployeeNo());
            createdAt = employee.getCreatedAt().toEpochSecond(ZoneOffset.UTC);
        }
    }
}
