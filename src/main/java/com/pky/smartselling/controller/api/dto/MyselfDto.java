package com.pky.smartselling.controller.api.dto;

import com.google.firebase.auth.FirebaseToken;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MyselfDto {
    @ApiModel("MyselfDto")
    @Data
    public static class Request {

    }

    @ApiModel("MyselfDto")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        String displayName;
        String email;
        public Response(FirebaseToken firebaseToken) {
            this.displayName = firebaseToken.getName();
            this.email = firebaseToken.getEmail();
        }
    }
}
