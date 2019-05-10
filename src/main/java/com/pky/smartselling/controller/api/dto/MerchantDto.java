package com.pky.smartselling.controller.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;

public class MerchantDto {

    @ApiModel("MerchantDto")
    @Data
    public static class Request {

        String merchantOwnerName;

        String merchantCompanyName;

        String fax;

        String phone;

        String tel;

        String businessLicenseNumber;

        String address;

        BigDecimal deposit;

        BigDecimal receivable;

        BigDecimal receipts;
    }

    @ApiModel("MerchantDto")
    @Data
    public static class Response extends Request{
        String customerId;
    }
}
