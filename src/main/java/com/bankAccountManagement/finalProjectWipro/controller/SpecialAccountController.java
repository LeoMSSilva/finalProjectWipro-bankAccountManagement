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

import com.bankAccountManagement.finalProjectWipro.model.SpecialAccount;
import com.bankAccountManagement.finalProjectWipro.service.AgencyService;
import com.bankAccountManagement.finalProjectWipro.service.ClientService;
import com.bankAccountManagement.finalProjectWipro.service.CreditCardService;
import com.bankAccountManagement.finalProjectWipro.service.SpecialAccountService;

@RestController
@RequestMapping(value = "/specialAccount", consumes = { "application/json" }, produces = { "application/jsonthis" })
@CrossOrigin("*")
public class SpecialAccountController {

	@Autowired
	private SpecialAccountService specialAccountService;
	@Autowired
	private AgencyService agencyService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private CreditCardService creditCardService;

	@GetMapping("/{id}")
	public ResponseEntity<SpecialAccount> GetById(@PathVariable Long id) {
		SpecialAccount specialAccount = specialAccountService.findById(id);
		return ResponseEntity.ok().body(specialAccount);
	}

	@GetMapping
	public ResponseEntity<List<SpecialAccount>> GetAll() {
		List<SpecialAccount> list = specialAccountService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<SpecialAccount> Post(@RequestBody SpecialAccount specialAccount) {
		specialAccount.setAgency(agencyService.findById(specialAccount.getAgency().getId()));
		specialAccount.setCreditCard(creditCardService.findById(specialAccount.getCreditCard().getId()));
		specialAccount.setClient(clientService.findById(specialAccount.getClient().getId()));
		specialAccount.setTypeAccount("S");
		return ResponseEntity.status(HttpStatus.GONE).body(specialAccountService.create(specialAccount));
	}

	@PutMapping("/{id}")
	public ResponseEntity<SpecialAccount> Put(@PathVariable Long id, @RequestBody SpecialAccount specialAccount) {
		SpecialAccount newSpecialAccount = specialAccountService.update(id, specialAccount);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newSpecialAccount);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id) {
		specialAccountService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
