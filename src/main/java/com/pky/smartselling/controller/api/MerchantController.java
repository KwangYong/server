package com.pky.smartselling.controller.api;

import com.pky.smartselling.configuration.constant.HttpRequestAttributes;
import com.pky.smartselling.controller.HashId;
import com.pky.smartselling.controller.api.dto.MerchantDto;
import com.pky.smartselling.domain.merchant.Merchant;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.service.MerchantService;
import com.pky.smartselling.util.ExceptionUtil;
import com.pky.smartselling.util.ModelMapperUtil;
import io.swagger.annotations.ApiImplicitParam;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/merchant/")
public class MerchantController {
    @Autowired
    MerchantService merchantService;


    @DeleteMapping(HttpRequestAttributes.HASHID_PAHT)
    @ApiImplicitParam(name = HttpRequestAttributes.HASHID, paramType = "path")
    public void deleteById(@RequestAttribute(name = HttpRequestAttributes.EMPLOYEE) Employee employee,
                                                       @RequestAttribute(name = HttpRequestAttributes.HASHID) HashId hashId) {
        merchantService.deleteCompany(hashId.getId(), employee);

    }

    @PostMapping
    public MerchantDto.Response add(@RequestAttribute(name = HttpRequestAttributes.EMPLOYEE) Employee employee, MerchantDto.Request customerDto) {
        Merchant merchant = new Merchant();
        BeanUtils.copyProperties(customerDto, merchant);
        merchant.setCompany(employee.getCompany().orElseThrow(ExceptionUtil.createNotFoundData("company", null)));
        merchantService.addCompany(merchant);
        return ModelMapperUtil.MODEL_MAPPER.map(merchant, MerchantDto.Response.class);
    }
}
