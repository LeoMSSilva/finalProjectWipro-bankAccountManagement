package com.bankAccountManagement.finalProjectWipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.CurrentAccount;
import com.bankAccountManagement.finalProjectWipro.repository.CurrentAccountRepository;

@Service
public class CurrentAccountService {

	@Autowired
	private CurrentAccountRepository currentAccountRepository;

	public CurrentAccount findById(Long id) {
		Optional<CurrentAccount> currentAccount = currentAccountRepository.findById(id);
		return currentAccount.orElse(null);
	}

	public List<CurrentAccount> findAll() {
		return currentAccountRepository.findAll();
	}

	public CurrentAccount update(Long id, CurrentAccount currentAccount) {
		CurrentAccount newCurrentAccount = findById(id);
		newCurrentAccount.setId(id);
		newCurrentAccount.setTypeAccount(currentAccount.getTypeAccount());
		newCurrentAccount.setBalance(currentAccount.getBalance());
		newCurrentAccount.setNumber(currentAccount.getNumber());
		newCurrentAccount.setAgency(currentAccount.getAgency());
		newCurrentAccount.setCreditCard(currentAccount.getCreditCard());
		newCurrentAccount.setClient(currentAccount.getClient());
		newCurrentAccount.setNumber(currentAccount.getNumber());
		return currentAccountRepository.save(newCurrentAccount);
	}

	public CurrentAccount create(CurrentAccount currentAccount) {
		return currentAccountRepository.save(currentAccount);
	}

	public void delete(Long id) {
		findById(id);
		currentAccountRepository.deleteById(id);
	}
}
