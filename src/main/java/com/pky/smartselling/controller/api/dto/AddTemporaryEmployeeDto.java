package com.pky.smartselling.controller.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;


public class AddTemporaryEmployeeDto {

    @ApiModel("AddTemporaryEmployeeDto")
    @Data
    public static class Request extends AddTemporaryEmployeeDto {
        Long departmentNo;
    }
    @ApiModel("AddTemporaryEmployeeDto")
    @Data
    @AllArgsConstructor
    public static class Response extends AddTemporaryEmployeeDto {
        String inviteCode;
    }
}
