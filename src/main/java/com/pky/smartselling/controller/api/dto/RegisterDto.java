package com.pky.smartselling.controller.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotNull;


public class RegisterDto {
    @ApiModel("RegisterDto")
    @Data
    public static class Request extends RegisterDto {
        @NotNull
        String inviteCode;
        @NotNull
        String email;
        @NotNull
        String password;
    }
    @ApiModel("RegisterDto")
    @Data
    public static class Response extends RegisterDto {

    }
}
