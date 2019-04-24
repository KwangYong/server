package com.pky.smartselling.repository;

import com.pky.smartselling.domain.sheet.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SheetRepository extends JpaRepository<Sheet, Long> {
}
