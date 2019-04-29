package com.pky.smartselling.util;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


public class HashIdsUtil {

    private static  String salt = "secret";

    public static Hashids hashids = new Hashids(salt, 5,"23456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public static String encode(long value){
        return hashids.encode(value);
    }

    public static Long decode(String value) {
        long[] values = hashids.decode(value);
        if(values.length == 1) {
            return values[0];
        }

        return null;
    }

}
