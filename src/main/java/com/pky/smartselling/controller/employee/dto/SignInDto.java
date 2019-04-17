package com.pky.smartselling.controller.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SignInDto {

    @Data
    public static class Request {
        String email;
        String password;
    }

    @AllArgsConstructor
    @Data
    public static class Response {
        String token;
    }
}

