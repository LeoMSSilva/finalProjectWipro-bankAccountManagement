package com.bankAccountManagement.finalProjectWipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.CurrentAccount;
import com.bankAccountManagement.finalProjectWipro.model.Historic;
import com.bankAccountManagement.finalProjectWipro.model.SpecialAccount;
import com.bankAccountManagement.finalProjectWipro.model.enums.HistoricType;
import com.bankAccountManagement.finalProjectWipro.repository.HistoricRepository;

@Service
public class HistoricService {

	@Autowired
	private HistoricRepository historicRepository;

	public Historic findById(Long id) {
		Optional<Historic> historic = historicRepository.findById(id);
		return historic.orElse(null);
	}

	public List<Historic> findAll() {
		return historicRepository.findAll();
	}

	public Historic create(Historic historic) {
		return historicRepository.save(historic);
	}

	public void instantiateWithdrawToAccountSpecial(double movedValue, SpecialAccount account) {
		create(new Historic(HistoricType.WITHDRAW, movedValue, account));
	}

	public void instantiateWithdrawToAccountCurrent(double movedValue, CurrentAccount account) {
		create(new Historic(HistoricType.WITHDRAW, movedValue, account));
	}

	public void instantiateDepositToAccountSpecial(double movedValue, SpecialAccount account) {
		create(new Historic(HistoricType.DEPOSIT, movedValue, account));
	}

	public void instantiateDepositToAccountCurrent(double movedValue, CurrentAccount account) {
		create(new Historic(HistoricType.DEPOSIT, movedValue, account));
	}

	public void instantiateTransferFromAccountSpecial(double movedValue, Long destinationAccountNumber,
			SpecialAccount account) {
		create(new Historic(destinationAccountNumber, HistoricType.TRANSFER_SENT, movedValue, account));
	}

	public void instantiateTransferFromAccountCurrent(double movedValue, Long destinationAccountNumber,
			CurrentAccount account) {
		create(new Historic(destinationAccountNumber, HistoricType.TRANSFER_SENT, movedValue, account));
	}

	public void instantiateTransferToAccountSpecial(double movedValue, Long originatingAccountNumber,
			SpecialAccount account) {
		create(new Historic(HistoricType.TRANSFER_RECEIVED, movedValue, account, originatingAccountNumber));
	}

	public void instantiateTransferToAccountCurrent(double movedValue, Long originatingAccountNumber,
			CurrentAccount account) {
		create(new Historic(HistoricType.TRANSFER_RECEIVED, movedValue, account, originatingAccountNumber));
	}

}
