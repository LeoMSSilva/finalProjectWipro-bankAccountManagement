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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Agency", tags = "Agency", description = "Agency routes")
@RestController
@RequestMapping(value = "/agency", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class AgencyController {

	@Autowired
	private AgencyService agencyService;

	@ApiOperation(value = "Returns an agency by id", notes = "This method returns an agency by id")
	@GetMapping("/{id}")
	public ResponseEntity<Agency> GetById(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		Agency agency = agencyService.findById(id);
		return ResponseEntity.ok().body(agency);
	}

	@ApiOperation(value = "Returns an agency by name", notes = "This method returns an agency by name")
	@GetMapping("/{name}")
	public ResponseEntity<Agency> GetById(@ApiParam(value = "Name", required = true) @PathVariable String name) {
		Agency agency = agencyService.findByAgencyName(name);
		return ResponseEntity.ok().body(agency);
	}

	@ApiOperation(value = "Returns all agencys", notes = "This method returns all agencys")
	@GetMapping
	public ResponseEntity<List<Agency>> GetAll() {
		List<Agency> list = agencyService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Create an agency by id", notes = "This method creates an agency by id")
	@PostMapping
	public ResponseEntity<Agency> Post(@ApiParam(value = "Agency", required = true) @RequestBody Agency agency) {
		agencyService.create(agency);
		return ResponseEntity.status(HttpStatus.GONE).body(agencyService.create(agency));
	}

	@ApiOperation(value = "Update an agency by id", notes = "This method updates an agency by id")
	@PutMapping("/{id}")
	public ResponseEntity<Agency> Put(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "Agency", required = true) @RequestBody Agency agency) {
		Agency newAgency = agencyService.update(id, agency);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newAgency);
	}

	@ApiOperation(value = "Delete an agency by id", notes = "This method deletes an agency by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		agencyService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
