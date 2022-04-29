package com.bankAccountManagement.finalProjectWipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.Manager;
import com.bankAccountManagement.finalProjectWipro.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	private ManagerRepository managerRepository;

	public Manager findById(Long id) {
		Optional<Manager> manager = managerRepository.findById(id);
		return manager.orElse(null);
	}

	public List<Manager> findAll() {
		return managerRepository.findAll();
	}

	public Manager update(Long id, Manager manager) {
		Manager newObj = findById(id);
		newObj.setId(id);
		newObj.setName(manager.getName());
		newObj.setCpf(manager.getCpf());
		newObj.setAddress(manager.getAddress());
		return managerRepository.save(newObj);
	}

	public Manager create(Manager manager) {
		return managerRepository.save(manager);
	}

	public void delete(Long id) {
		findById(id);
		managerRepository.deleteById(id);
	}

}
