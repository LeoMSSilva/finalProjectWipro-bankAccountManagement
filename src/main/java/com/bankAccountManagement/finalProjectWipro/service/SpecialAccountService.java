package com.bankAccountManagement.finalProjectWipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.SpecialAccount;
import com.bankAccountManagement.finalProjectWipro.repository.SpecialAccountRepository;

@Service
public class SpecialAccountService {

	@Autowired
	private SpecialAccountRepository specialAccountRepository;

	public SpecialAccount findById(Long id) {
		Optional<SpecialAccount> specialAccount = specialAccountRepository.findById(id);
		return specialAccount.orElse(null);
	}

	public List<SpecialAccount> findAll() {
		return specialAccountRepository.findAll();
	}

	public SpecialAccount update(Long id, SpecialAccount specialAccount) {
		SpecialAccount newSpecialAccount = findById(id);
		newSpecialAccount.setId(id);
		newSpecialAccount.setLimitValue(specialAccount.getLimitValue());
		newSpecialAccount.setTypeAccount(specialAccount.getTypeAccount());
		newSpecialAccount.setBalance(specialAccount.getBalance());
		newSpecialAccount.setNumber(specialAccount.getNumber());
		newSpecialAccount.setAgency(specialAccount.getAgency());
		newSpecialAccount.setCreditCard(specialAccount.getCreditCard());
		newSpecialAccount.setClient(specialAccount.getClient());
		newSpecialAccount.setNumber(specialAccount.getNumber());
		return specialAccountRepository.save(newSpecialAccount);
	}

	public SpecialAccount create(SpecialAccount specialAccount) {
		return specialAccountRepository.save(specialAccount);
	}

	public void delete(Long id) {
		findById(id);
		specialAccountRepository.deleteById(id);
	}
}
