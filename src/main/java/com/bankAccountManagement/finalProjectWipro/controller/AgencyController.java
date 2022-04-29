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

import com.bankAccountManagement.finalProjectWipro.model.Agency;
import com.bankAccountManagement.finalProjectWipro.service.AgencyService;

	
	
	
	
	
	
	@RestController
@RequestMapping(value = "/agency", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class AgencyController {

	@Autowired
	private AgencyService agencyService;

	@GetMapping("/{id}")
	public ResponseEntity<Agency> GetById(@PathVariable Long id) {
		Agency agency = agencyService.findById(id);
		return ResponseEntity.ok().body(agency);
	}

	@GetMapping("/{name}")
	public ResponseEntity<Agency> GetById(@PathVariable String name) {
		Agency agency = agencyService.findByAgencyName(name);
		return ResponseEntity.ok().body(agency);
	}

	@GetMapping
	public ResponseEntity<List<Agency>> GetAll() {
		List<Agency> list = agencyService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Agency> Post(@RequestBody Agency agency) {
		agencyService.create(agency);
		return ResponseEntity.status(HttpStatus.GONE).body(agencyService.create(agency));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Agency> Put(@PathVariable Long id, @RequestBody Agency agency) {
		Agency newAgency = agencyService.update(id, agency);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newAgency);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id) {
		agencyService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
