package com.pky.smartselling.controller.admin;

import com.pky.smartselling.controller.admin.dto.AdminCompanyDto;
import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.service.CompanyService;
import com.pky.smartselling.util.ModelMapperUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/admin/api/v1/company/")
@RestController
public class AdminCompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping
    public ResponseEntity addCompany(@RequestBody @Valid AdminCompanyDto.Request dto) {
        return ResponseEntity.ok(
                new AdminCompanyDto.Response(companyService.addCompany(ModelMapperUtil.MODEL_MAPPER.map(dto, Company.class)).getCompanyNo()));
    }

    @PutMapping
    public ResponseEntity updateCompany(@RequestBody @Valid AdminCompanyDto.Request dto) {
        return ResponseEntity.ok(
                new AdminCompanyDto.Response(companyService.addCompany(ModelMapperUtil.MODEL_MAPPER.map(dto, Company.class)).getCompanyNo()));
    }
}
