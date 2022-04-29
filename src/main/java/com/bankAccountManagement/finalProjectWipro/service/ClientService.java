package com.bankAccountManagement.finalProjectWipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.Client;
import com.bankAccountManagement.finalProjectWipro.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public Client findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.orElse(null);
	}

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client update(Long id, Client client) {
		Client newObj = findById(id);
		newObj.setId(id);
		newObj.setName(client.getName());
		newObj.setCpf(client.getCpf());
		newObj.setAddress(client.getAddress());
		return clientRepository.save(newObj);
	}

	public Client create(Client client) {
		return clientRepository.save(client);
	}

	public void delete(Long id) {
		findById(id);
		clientRepository.deleteById(id);
	}
}
