package com.bankAccountManagement.finalProjectWipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.CreditCard;
import com.bankAccountManagement.finalProjectWipro.repository.CreditCardRepository;

@Service
public class CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;

	public CreditCard findById(Long id) {
		Optional<CreditCard> creditCard = creditCardRepository.findById(id);
		return creditCard.orElse(null);
	}

	public List<CreditCard> findAll() {
		return creditCardRepository.findAll();
	}

	public CreditCard update(Long id, CreditCard creditCard) {
		CreditCard newObj = findById(id);
		newObj.setId(id);
		newObj.setCardNumber(creditCard.getCardNumber());
		newObj.setCvv(creditCard.getCvv());
		return creditCardRepository.save(newObj);
	}

	public CreditCard create(CreditCard creditCard) {
		return creditCardRepository.save(creditCard);
	}

	public void delete(Long id) {
		findById(id);
		creditCardRepository.deleteById(id);
	}
}
