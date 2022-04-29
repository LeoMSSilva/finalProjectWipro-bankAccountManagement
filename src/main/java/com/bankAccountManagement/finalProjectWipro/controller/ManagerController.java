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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Manager", tags = "Manager", description = "Manager routes")
@RestController
@RequestMapping(value = "/manager", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class ManagerController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private AgencyService agencyService;

	@ApiOperation(value = "Returns a manager by id", notes = "This method returns a manager by id")
	@GetMapping("/{id}")
	public ResponseEntity<Manager> GetById(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		Manager manager = managerService.findById(id);
		return ResponseEntity.ok().body(manager);
	}

	@ApiOperation(value = "Returns all managers", notes = "This method returns all managers")
	@GetMapping
	public ResponseEntity<List<Manager>> GetAll() {
		List<Manager> list = managerService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Create a new manager", notes = "This method creates a new manager")
	@PostMapping
	public ResponseEntity<Manager> PostByAgency(
			@ApiParam(value = "Manager", required = true) @RequestBody Manager manager) {
		manager.setAgency(agencyService.findById(manager.getAgency().getId()));
		return ResponseEntity.status(HttpStatus.GONE).body(managerService.create(manager));
	}

	@ApiOperation(value = "Update a manager by id", notes = "This method updates a manager by id")
	@PutMapping("/{id}")
	public ResponseEntity<Manager> Put(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "Manager", required = true) @RequestBody Manager manager) {
		Manager newManager = managerService.update(id, manager);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newManager);
	}

	@ApiOperation(value = "Delete a manager by id", notes = "This method deletes a manager by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		managerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
