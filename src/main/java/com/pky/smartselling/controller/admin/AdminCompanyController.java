package com.pky.smartselling.controller.admin;

import com.pky.smartselling.controller.admin.dto.AdminCompanyDto;
import com.pky.smartselling.domain.company.Company;
import com.pky.smartselling.service.CompanyService;
import com.pky.smartselling.util.HashIdsUtil;
import com.pky.smartselling.util.ModelMapperUtil;
import org.hashids.Hashids;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@RequestMapping("/admin/api/v1/company/")
@RestController
public class AdminCompanyController {


    @Autowired
    CompanyService companyService;

    @PostMapping
    public ResponseEntity<AdminCompanyDto.Response> addCompany(@RequestBody @Valid AdminCompanyDto.Request dto) {

        return ResponseEntity.ok(ModelMapperUtil.MODEL_MAPPER.map(companyService.addCompany(Company.builder().companyName(dto.getCompanyName()).companyStatus(dto.getStatus()).build()),
                AdminCompanyDto.Response.class));
    }

    @PutMapping
    public ResponseEntity updateCompany(@RequestBody @Valid AdminCompanyDto.Request dto) {
        return ResponseEntity.ok(null);
    }

    @GetMapping("{companyNo}")
    public ResponseEntity findById(@PathVariable("companyNo") String companyId) {
        return ResponseEntity.ok(companyService.findById(HashIdsUtil.decode(companyId)));
    }

    @GetMapping()
    public ResponseEntity findByAll() {
        return ResponseEntity.ok(companyService.findByAll());
    }
}
