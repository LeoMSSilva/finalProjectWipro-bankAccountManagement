package com.bankAccountManagement.finalProjectWipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankAccountManagement.finalProjectWipro.model.Account;
import com.bankAccountManagement.finalProjectWipro.service.AccountService;
import com.bankAccountManagement.finalProjectWipro.service.TransactionService;
import com.bankAccountManagement.finalProjectWipro.utils.TransferForm;

@RestController
@RequestMapping(value = "/transaction", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class TransactionController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;

	@GetMapping("balance/{id}")
	public ResponseEntity<String> Balance(@PathVariable Long id) {
		Account account = accountService.findById(id);
		String myBalance = String.format("Current balance: %.2f", account.getBalance());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(myBalance);
	}

	@PutMapping("transfer/{id}")
	public ResponseEntity<String> Transfer(@PathVariable Long id, @RequestBody TransferForm form) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionService.transfer(id, form));
	}

	@PutMapping("deposit/{id}")
	public ResponseEntity<String> Deposit(@PathVariable Long id, @RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionService.deposit(id, account));
	}

	@PutMapping("withdraw/{id}")
	public ResponseEntity<String> Withdraw(@PathVariable Long id, @RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionService.withdraw(id, account));

	}
}