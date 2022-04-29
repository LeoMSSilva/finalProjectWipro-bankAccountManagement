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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Current Account", tags = "Current Account", description = "Current Account routes")
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

	@ApiOperation(value = "Returns a current account by id", notes = "This method returns a current account by id")
	@GetMapping("/{id}")
	public ResponseEntity<CurrentAccount> GetById(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		CurrentAccount currentAccount = currentAccountService.findById(id);
		return ResponseEntity.ok().body(currentAccount);
	}

	@ApiOperation(value = "Returns all current accounts", notes = "This method returns all current accounts")
	@GetMapping
	public ResponseEntity<List<CurrentAccount>> GetAll() {
		List<CurrentAccount> list = currentAccountService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Create a current account by id", notes = "This method creates a current account by id")
	@PostMapping
	public ResponseEntity<CurrentAccount> Post(
			@ApiParam(value = "Current Account", required = true) @RequestBody CurrentAccount currentAccount) {
		currentAccount.setAgency(agencyService.findById(currentAccount.getAgency().getId()));
		currentAccount.setCreditCard(creditCardService.findById(currentAccount.getCreditCard().getId()));
		currentAccount.setClient(clientService.findById(currentAccount.getClient().getId()));
		currentAccount.setTypeAccount("C");
		return ResponseEntity.status(HttpStatus.GONE).body(currentAccountService.create(currentAccount));
	}

	@ApiOperation(value = "Update a current account by id", notes = "This method updates a current account by id")
	@PutMapping("/{id}")
	public ResponseEntity<CurrentAccount> Put(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "Current Account", required = true) @RequestBody CurrentAccount currentAccount) {
		CurrentAccount newCurrentAccount = currentAccountService.update(id, currentAccount);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newCurrentAccount);
	}

	@ApiOperation(value = "Delete a current account by id", notes = "This method deletes a current account by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		currentAccountService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
