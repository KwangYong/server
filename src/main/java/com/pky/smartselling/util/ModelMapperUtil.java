package com.pky.smartselling.util;

import com.google.firebase.auth.FirebaseToken;
import com.pky.smartselling.controller.admin.dto.AdminCompanyDto;
import com.pky.smartselling.controller.api.dto.MerchantDto;
import com.pky.smartselling.controller.api.dto.MyselfDto;
import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.domain.merchant.Merchant;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class ModelMapperUtil {
    public static ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ModelMapper();
        MODEL_MAPPER.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        registerCompanyToAdminCompanyDtoResponse(MODEL_MAPPER);
        registerCustomerToCustomerDtoResponse(MODEL_MAPPER);
        registerFirebaseTokenToMyselfDtoResponse(MODEL_MAPPER);
    }

    static void registerCompanyToAdminCompanyDtoResponse(ModelMapper modelMapper) {
        TypeMap<Company, AdminCompanyDto.Response> type =  modelMapper.createTypeMap(Company.class, AdminCompanyDto.Response.class);
        type.addMappings(mapping -> mapping.map(Company::getCompanyNo, AdminCompanyDto.Response::setCompanyId));

        type.setPostConverter( context -> {
            context.getDestination().setCompanyId(HashIdsUtil.encode(context.getSource().getCompanyNo()));
            return context.getDestination();
        });
    }

    static void registerCustomerToCustomerDtoResponse(ModelMapper modelMapper) {
        TypeMap<Merchant, MerchantDto.Response> type =  modelMapper.createTypeMap(Merchant.class, MerchantDto.Response.class);
        type.addMappings(mapping -> mapping.map(Merchant::getCustomerNo, MerchantDto.Response::setCustomerId));

        type.setPostConverter( context -> {
            context.getDestination().setCustomerId(HashIdsUtil.encode(context.getSource().getCustomerNo()));
            return context.getDestination();
        });
    }

    static void registerFirebaseTokenToMyselfDtoResponse(ModelMapper modelMapper) {
        TypeMap<FirebaseToken, MyselfDto.Response> typeMap = modelMapper.createTypeMap(FirebaseToken.class, MyselfDto.Response.class);
        typeMap.addMappings(mapping -> mapping.map(FirebaseToken::getName, MyselfDto.Response::setDisplayName));
        typeMap.addMappings(mapping -> mapping.map(FirebaseToken::getEmail, MyselfDto.Response::setEmail));
    }

}
