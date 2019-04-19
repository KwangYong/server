package com.pky.smartselling.util;

import org.hashids.Hashids;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HashIdsUtil {

    @Value("${com.pky.smartselling.hashids.salt:secret}")
    private String salt = "secret";

    Hashids hashids;

    @PostConstruct
    public void hashIds() {
        this.hashids = new Hashids(salt);
    }

    public String encode(long value){
        return hashids.encode(value);
    }

    public Long decode(String value) {
        long[] values = hashids.decode(value);
        if(values.length == 1) {
            return values[0];
        }

        return null;
    }

}
