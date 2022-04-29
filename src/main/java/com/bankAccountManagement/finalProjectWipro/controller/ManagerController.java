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

import com.bankAccountManagement.finalProjectWipro.model.Manager;
import com.bankAccountManagement.finalProjectWipro.service.AgencyService;
import com.bankAccountManagement.finalProjectWipro.service.ManagerService;

@RestController
@RequestMapping(value = "/manager", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private AgencyService agencyService;

	@GetMapping("/{id}")
	public ResponseEntity<Manager> GetById(@PathVariable Long id) {
		Manager manager = managerService.findById(id);
		return ResponseEntity.ok().body(manager);
	}

	@GetMapping
	public ResponseEntity<List<Manager>> GetAll() {
		List<Manager> list = managerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Manager> PostByAgency(@RequestBody Manager manager) {
		manager.setAgency(agencyService.findById(manager.getAgency().getId()));
		return ResponseEntity.status(HttpStatus.GONE).body(managerService.create(manager));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Manager> Put(@PathVariable Long id, @RequestBody Manager manager) {
		Manager newManager = managerService.update(id, manager);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newManager);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@PathVariable Long id) {
		managerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
