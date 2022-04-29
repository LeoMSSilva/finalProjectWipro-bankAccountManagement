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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Transaction", tags = "Transaction", description = "Transaction routes")
@RestController
@RequestMapping(value = "/transaction", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class TransactionController {

	@Autowired
	private AccountService accountService;
	@Autowired
	private TransactionService transactionService;

	@ApiOperation(value = "Returns an account balance", notes = "This method returns the balance of an account")
	@GetMapping("balance/{id}")
	public ResponseEntity<String> Balance(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		Account account = accountService.findById(id);
		String myBalance = String.format("Current balance: %.2f", account.getBalance());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(myBalance);
	}

	@ApiOperation(value = "Bank transfer between accounts", notes = "This method makes the bank transfer between accounts")
	@PutMapping("transfer/{id}")
	public ResponseEntity<String> Transfer(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "form", required = true) @RequestBody TransferForm form) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionService.transfer(id, form));
	}

	@ApiOperation(value = "Deposit from an account", notes = "This method makes the Deposit in an account")
	@PutMapping("deposit/{id}")
	public ResponseEntity<String> Deposit(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "Account", required = true) @RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionService.deposit(id, account));
	}

	@ApiOperation(value = "Withdraw from an account", notes = "This method makes the withdrawal in an account")
	@PutMapping("withdraw/{id}")
	public ResponseEntity<String> Withdraw(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "Account", required = true) @RequestBody Account account) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactionService.withdraw(id, account));

	}
}