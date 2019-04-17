package com.pky.smartselling.controller.employee.dto;

import com.pky.smartselling.domain.employee.Employee;
import lombok.Data;

import javax.validation.constraints.NotNull;


public class RegisterDto {
    @Data
    public static class Request extends RegisterDto {
        @NotNull
        String inviteCode;
        @NotNull
        String email;
        @NotNull
        String password;
    }
    @Data
    public static class Response extends RegisterDto {

    }
}
