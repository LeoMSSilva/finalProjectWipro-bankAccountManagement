package com.bankAccountManagement.finalProjectWipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.Agency;
import com.bankAccountManagement.finalProjectWipro.repository.AgencyRepository;

@Service
public class AgencyService {

	@Autowired
	private AgencyRepository agencyRepository;

	public Agency findById(Long id) {
		Optional<Agency> agency = agencyRepository.findById(id);
		return agency.orElse(null);
	}

	public Agency findByAgencyName(String agencyName) {
		return agencyRepository.findByAgencyName(agencyName);
	}

	public List<Agency> findAll() {
		return agencyRepository.findAll();
	}

	public Agency update(Long id, Agency agency) {
		Agency newObj = findById(id);
		newObj.setId(id);
		newObj.setAgencyName(agency.getAgencyName());
		newObj.setAgencyNumber(agency.getAgencyNumber());
		newObj.setCnpj(agency.getCnpj());
		return agencyRepository.save(newObj);
	}

	public Agency create(Agency agency) {
		return agencyRepository.save(agency);
	}

	public void delete(Long id) {
		findById(id);
		agencyRepository.deleteById(id);
	}

}
