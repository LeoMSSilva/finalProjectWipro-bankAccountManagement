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

import com.bankAccountManagement.finalProjectWipro.model.Client;
import com.bankAccountManagement.finalProjectWipro.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Client", tags = "Client", description = "Client routes")
@RestController
@RequestMapping(value = "/client", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class ClientController {

	@Autowired
	private ClientService service;

	@ApiOperation(value = "Returns a client by id", notes = "This method returns a client by id")
	@GetMapping("/{id}")
	public ResponseEntity<Client> GetById(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		Client client = this.service.findById(id);
		return ResponseEntity.ok().body(client);
	}

	@ApiOperation(value = "Returns all clients", notes = "This method returns all clients")
	@GetMapping
	public ResponseEntity<List<Client>> GetAll() {
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@ApiOperation(value = "Create a new client", notes = "This method creates a new client")
	@PostMapping
	public ResponseEntity<Client> Post(@ApiParam(value = "Client", required = true) @RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.GONE).body(service.create(client));
	}

	@ApiOperation(value = "Update a client by id", notes = "This method updates a client by id")
	@PutMapping("/{id}")
	public ResponseEntity<Client> Put(@ApiParam(value = "id", required = true) @PathVariable Long id,
			@ApiParam(value = "Client", required = true) @RequestBody Client client) {
		Client newClient = service.update(id, client);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newClient);
	}

	@ApiOperation(value = "Delete a client by id", notes = "This method deletes a client by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> Delete(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
