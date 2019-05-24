package com.pky.smartselling.configuration.constant;

import lombok.Data;


public enum ErrorCode {
    AUTH_FIRBASE_TOKEN_NOT_YET_VALID("로그인 정보가 올바르지 못합니다. 재 로그인을 해주세요.", "AUTH001")
    ;
    String message;
    String code;
    ErrorCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
