package com.bankAccountManagement.finalProjectWipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.Account;
import com.bankAccountManagement.finalProjectWipro.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;

	public Account findById(Long id) {
		Optional<Account> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Account> findAll() {
		return repository.findAll();
	}

}