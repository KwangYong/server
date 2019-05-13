package com.pky.smartselling.controller.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

public class MyselfDto {
    @ApiModel("MyselfDto")
    @Data
    public static class Request {

    }

    @ApiModel("MyselfDto")
    @Data
    public static class Response {
        String displayName;
        String email;
    }
}
