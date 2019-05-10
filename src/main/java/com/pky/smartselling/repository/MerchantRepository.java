package com.pky.smartselling.repository;

import com.pky.smartselling.domain.merchant.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    List<Merchant> findAllByCompanyCompanyNoAndDeletedByIsNull(long companyNo);
    Optional<Merchant> findByCustomerNoAndDeletedByIsNull(long customerNo);
}
