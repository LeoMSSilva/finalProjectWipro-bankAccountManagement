package com.bankAccountManagement.finalProjectWipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankAccountManagement.finalProjectWipro.model.Account;
import com.bankAccountManagement.finalProjectWipro.model.Historic;
import com.bankAccountManagement.finalProjectWipro.repository.HistoricRepository;
import com.bankAccountManagement.finalProjectWipro.service.AccountService;
import com.bankAccountManagement.finalProjectWipro.service.HistoricService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Historic", tags = "Historic", description = "Historic routes")
@RestController
@RequestMapping(value = "/historic", consumes = { "application/json" }, produces = { "application/json" })
@CrossOrigin("*")
public class HistoricController {

	@Autowired
	private HistoricService historicService;
	@Autowired
	private HistoricRepository historicRepository;
	@Autowired
	private AccountService accountService;

	@ApiOperation(value = "Returns the history of an account", notes = "This method returns the history of an account")
	@GetMapping("/{id}")
	public ResponseEntity<List<Historic>> GetById(@ApiParam(value = "id", required = true) @PathVariable Long id) {
		Account account = accountService.findById(id);
		List<Historic> historic = historicRepository.findByAccount(account);
		return ResponseEntity.ok().body(historic);
	}

	@ApiOperation(value = "Returns the history of all accounts", notes = "This method returns the history of all accounts")
	@GetMapping
	public ResponseEntity<List<Historic>> GetAll() {
		List<Historic> historic = historicService.findAll();
		return ResponseEntity.ok().body(historic);
	}
}
