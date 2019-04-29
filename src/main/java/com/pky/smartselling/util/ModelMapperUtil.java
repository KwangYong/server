package com.pky.smartselling.util;

import com.pky.smartselling.controller.admin.dto.AdminCompanyDto;
import com.pky.smartselling.domain.company.Company;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class ModelMapperUtil {
    public static ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ModelMapper();
        TypeMap<Company, AdminCompanyDto.Response> type =  ModelMapperUtil.MODEL_MAPPER.createTypeMap(Company.class, AdminCompanyDto.Response.class);
        type.addMappings(mapping -> {
            mapping.map(Company::getCompanyNo, AdminCompanyDto.Response::setCompanyId);
        });

        type.setPreConverter( context -> {
            context.getDestination().setCompanyId(HashIdsUtil.encode(context.getSource().getCompanyNo()));
            return context.getDestination();
        });
    }
}
