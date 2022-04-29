package com.bankAccountManagement.finalProjectWipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankAccountManagement.finalProjectWipro.model.CurrentAccount;
import com.bankAccountManagement.finalProjectWipro.service.AgencyService;
import com.bankAccountManagement.finalProjectWipro.service.ClientService;
import com.bankAccountManagement.finalProjectWipro.service.CreditCardService;
import com.bankAccountManagement.finalProjectWipro.service.CurrentAccountService;

@RestController
@RequestMapping(value = "/currentAccount", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class CurrentAccountController {

	@Autowired
	private CurrentAccountService currentAccountService;
	@Autowired
	private AgencyService agencyService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CreditCardService creditCardService;

	@GetMapping("/{id}")
	public ResponseEntity<CurrentAccount> GetById(@PathVariable Long id) {
		CurrentAccount currentAccount = currentAccountService.findById(id);
		return ResponseEntity.ok().body(currentAccount);
	}

	@GetMapping
	public ResponseEntity<List<CurrentAccount>> GetAll() {
		List<CurrentAccount> list = currentAccountService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<CurrentAccount> Post(@RequestBody CurrentAccount currentAccount) {
		currentAccount.setAgency(agencyService.findById(currentAccount.getAgency().getId()));
		currentAccount.setCreditCard(creditCardService.findById(currentAccount.getCreditCard().getId()));
		currentAccount.setClient(clientService.findById(currentAccount.getClient().getId()));
		currentAccount.setTypeAccount("C");
		return ResponseEntity.status(HttpStatus.GONE).body(currentAccountService.create(currentAccount));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CurrentAccount> Put(@PathVariable Long id, @RequestBody CurrentAccount currentAccount) {
		CurrentAccount newCurrentAccount = currentAccountService.update(id, currentAccount);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newCurrentAccount);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id) {
		currentAccountService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
