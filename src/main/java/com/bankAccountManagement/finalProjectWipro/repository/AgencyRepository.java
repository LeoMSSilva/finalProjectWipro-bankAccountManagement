package com.bankAccountManagement.finalProjectWipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankAccountManagement.finalProjectWipro.model.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long> {
	Agency findByAgencyName(String agencyName);
}
