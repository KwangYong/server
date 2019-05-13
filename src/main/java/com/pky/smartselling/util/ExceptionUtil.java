package com.pky.smartselling.util;

import com.pky.smartselling.exception.NotFoundDataException;

import java.util.function.Supplier;

public class ExceptionUtil {
    public static Supplier createNotFoundData(String prefix, Object value) {
        return  () -> new NotFoundDataException(String.format("%s not exist %s", prefix ,String.valueOf(value)));
    }
}
