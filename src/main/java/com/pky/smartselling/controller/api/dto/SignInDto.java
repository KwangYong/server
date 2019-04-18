package com.pky.smartselling.controller.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

public class SignInDto {

    @ApiModel("SignInDto")
    @Data
    public static class Request {
        String email;
        String password;
    }

    @ApiModel("SignInDto")
    @AllArgsConstructor
    @Data
    public static class Response {
        String token;
    }
}

