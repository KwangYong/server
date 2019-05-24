package com.pky.smartselling.util;

import com.pky.smartselling.configuration.constant.ErrorCode;
import com.pky.smartselling.exception.NotFoundDataException;

import java.util.function.Supplier;

public class ExceptionUtil {
    public static Supplier createNotFoundData(String prefix, Object value) {
        return  () -> new NotFoundDataException(String.format("%s not exist %s", prefix ,String.valueOf(value)));
    }

    public static String errorMessage(ErrorCode errorCode) {
        return String.format("%s Error code: %s", errorCode.getMessage(), errorCode.getCode());
    }
}
