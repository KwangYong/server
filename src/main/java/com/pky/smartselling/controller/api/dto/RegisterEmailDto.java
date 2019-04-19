package com.pky.smartselling.controller.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;


public class RegisterEmailDto {
    @ApiModel("RegisterEmailDto")
    @Data
    public static class Request {
        @NotNull
        String email;
        @NotNull
        String password;
    }
    @AllArgsConstructor
    @ApiModel("RegisterEmailDto")
    @Data
    public static class Response  {
    }
}
