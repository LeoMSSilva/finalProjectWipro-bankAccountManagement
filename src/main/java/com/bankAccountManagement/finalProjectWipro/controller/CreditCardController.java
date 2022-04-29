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

@RestController
@RequestMapping(value = "/creditCard", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class CreditCardController {

	@Autowired
	private CreditCardService creditCardService;

	@GetMapping("/{id}")
	public ResponseEntity<CreditCard> GetById(@PathVariable Long id) {
		CreditCard creditCard = creditCardService.findById(id);
		return ResponseEntity.ok().body(creditCard);
	}

	@GetMapping
	public ResponseEntity<List<CreditCard>> GetAll() {
		List<CreditCard> list = creditCardService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<CreditCard> Post(@RequestBody CreditCard creditCard) {
		return ResponseEntity.status(HttpStatus.GONE).body(creditCardService.create(creditCard));
	}

	@PutMapping("/{id}")
	public ResponseEntity<CreditCard> Put(@PathVariable Long id, @RequestBody CreditCard creditCard) {
		CreditCard newCreditCard = creditCardService.update(id, creditCard);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newCreditCard);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id) {
		creditCardService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
