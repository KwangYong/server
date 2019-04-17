package com.pky.smartselling.controller.employee.dto;

import lombok.Data;

public class SignInDto {

    @Data
    public static class Request {
        String email;
        String password;

    }


}

