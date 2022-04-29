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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Special Account", tags = "Special Account", description = "Special Account routes")
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

	@ApiOperation(value = "Returns a special account by id", notes = "This method returns a special account by id")
	@GetMapping("/{id}")
	public ResponseEntity<SpecialAccount> GetById(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		SpecialAccount specialAccount = specialAccountService.findById(id);
		return ResponseEntity.ok().body(specialAccount);
	}

	@ApiOperation(value = "Returns all special accounts", notes = "This method returns all special accounts")
	@GetMapping
	public ResponseEntity<List<SpecialAccount>> GetAll() {
		List<SpecialAccount> list = specialAccountService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Create a special account by id", notes = "This method creates a special account by id")
	@PostMapping
	public ResponseEntity<SpecialAccount> Post(
			@ApiParam(value = "Special Account", required = true) @RequestBody SpecialAccount specialAccount) {
		specialAccount.setAgency(agencyService.findById(specialAccount.getAgency().getId()));
		specialAccount.setCreditCard(creditCardService.findById(specialAccount.getCreditCard().getId()));
		specialAccount.setClient(clientService.findById(specialAccount.getClient().getId()));
		specialAccount.setTypeAccount("S");
		return ResponseEntity.status(HttpStatus.GONE).body(specialAccountService.create(specialAccount));
	}

	@ApiOperation(value = "Update a special account by id", notes = "This method updates a special account by id")
	@PutMapping("/{id}")
	public ResponseEntity<SpecialAccount> Put(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "Special Account", required = true) @RequestBody SpecialAccount specialAccount) {
		SpecialAccount newSpecialAccount = specialAccountService.update(id, specialAccount);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newSpecialAccount);
	}

	@ApiOperation(value = "Delete a special account by id", notes = "This method deletes a special account by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		specialAccountService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
