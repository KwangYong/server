package com.pky.smartselling.service;

import com.pky.smartselling.domain.merchant.Merchant;
import com.pky.smartselling.domain.employee.Employee;
import com.pky.smartselling.repository.MerchantRepository;
import com.pky.smartselling.util.ExceptionUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MerchantService {
    final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Transactional
    public Merchant addCompany(Merchant merchant){
       return merchantRepository.save(merchant);
    }

    @Transactional
    public Merchant deleteCompany (long customerNo, Employee employee) {
        Merchant merchant = merchantRepository.findByCustomerNoAndDeletedByIsNull(customerNo).orElseGet(ExceptionUtil.createNotFoundData("merchant", customerNo));
        merchant.setDeletedBy(employee.getEmployeeNo());
        merchant.setDeletedAt(LocalDateTime.now());
        return merchant;
    }

    @Transactional(readOnly = true)
    public List<Merchant> findAllByCompany(long companyNo) {
        return merchantRepository.findAllByCompanyCompanyNoAndDeletedByIsNull(companyNo);
    }


}
