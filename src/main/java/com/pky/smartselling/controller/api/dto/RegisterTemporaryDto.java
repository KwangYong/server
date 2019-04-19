package com.pky.smartselling.controller.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;


public class RegisterTemporaryDto {

    @ApiModel("RegisterTemporaryDto")
    @Data
    public static class Request extends RegisterTemporaryDto {
        Long departmentNo;
    }
    @ApiModel("RegisterTemporaryDto")
    @Data
    @AllArgsConstructor
    public static class Response extends RegisterTemporaryDto {
        String inviteCode;
    }
}
