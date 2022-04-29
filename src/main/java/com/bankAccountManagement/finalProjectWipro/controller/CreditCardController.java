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

import com.bankAccountManagement.finalProjectWipro.model.CreditCard;
import com.bankAccountManagement.finalProjectWipro.service.CreditCardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "CreditCard", tags = "Credit Card", description = "Credit Card routes")
@RestController
@RequestMapping(value = "/creditCard", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	@ApiOperation(value = "Returns a credit card by id", notes = "This method returns a credit card by id")
	@GetMapping("/{id}")
	public ResponseEntity<CreditCard> GetById(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		CreditCard creditCard = creditCardService.findById(id);
		return ResponseEntity.ok().body(creditCard);
	}

	@ApiOperation(value = "Returns all credit cards", notes = "This method returns all credit cards")
	@GetMapping
	public ResponseEntity<List<CreditCard>> GetAll() {
		List<CreditCard> list = creditCardService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Create a credit card by id", notes = "This method creates a credit card by id")
	@PostMapping
	public ResponseEntity<CreditCard> Post(
			@ApiParam(value = "CreditCard", required = true) @RequestBody CreditCard creditCard) {
		return ResponseEntity.status(HttpStatus.GONE).body(creditCardService.create(creditCard));
	}

	@ApiOperation(value = "Update a credit card by id", notes = "This method updates a credit card by id")
	@PutMapping("/{id}")
	public ResponseEntity<CreditCard> Put(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "CreditCard", required = true) @RequestBody CreditCard creditCard) {
		CreditCard newCreditCard = creditCardService.update(id, creditCard);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newCreditCard);
	}

	@ApiOperation(value = "Delete a credit card by id", notes = "This method deletes a credit card by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		creditCardService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
