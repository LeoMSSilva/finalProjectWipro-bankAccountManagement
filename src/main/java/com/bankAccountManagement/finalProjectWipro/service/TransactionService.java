package com.bankAccountManagement.finalProjectWipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankAccountManagement.finalProjectWipro.model.Account;
import com.bankAccountManagement.finalProjectWipro.model.CurrentAccount;
import com.bankAccountManagement.finalProjectWipro.model.SpecialAccount;
import com.bankAccountManagement.finalProjectWipro.utils.TransferForm;

@Service
public class TransactionService {

	@Autowired
	private CurrentAccountService accountCurrentService;
	@Autowired
	private SpecialAccountService accountSpecialService;
	@Autowired
	private AccountService accountService;
	@Autowired
	private HistoricService historicService;

	public String deposit(Long id, Account account) {
		Account myAccount = accountService.findById(id);
		String typeAccount = myAccount.getTypeAccount();
		if (typeAccount.equals("S")) {
			SpecialAccount newAccountSpecial = accountSpecialService.findById(id);
			newAccountSpecial.setBalance(account.getBalance() + newAccountSpecial.getBalance());
			accountSpecialService.update(id, newAccountSpecial);
			historicService.instantiateDepositToAccountSpecial(account.getBalance(), newAccountSpecial);
			return String.format("Current balance: %.2f\\nCurrent special limit: %.2f", newAccountSpecial.getBalance(),
					newAccountSpecial.getLimitValue());
		} else if (typeAccount.equals("C")) {
			CurrentAccount newAccountCurrent = accountCurrentService.findById(id);
			newAccountCurrent.setBalance(account.getBalance() + newAccountCurrent.getBalance());
			accountCurrentService.update(id, newAccountCurrent);
			historicService.instantiateDepositToAccountCurrent(account.getBalance(), newAccountCurrent);
			return String.format("Current balance: %.2f", newAccountCurrent.getBalance());
		} else {
			return "An error has occurred!\\n Please try again later.";
		}
	}

	public String withdraw(Long id, Account account) {
		Account myAccount = accountService.findById(id);
		if (myAccount.getTypeAccount().equals("S")) {
			SpecialAccount newAccountSpecial = accountSpecialService.findById(id);
			if (newAccountSpecial.getBalance() - account.getBalance() < 0) {
				if (newAccountSpecial.getBalance() - account.getBalance() + newAccountSpecial.getLimitValue() >= 0) {
					newAccountSpecial.setLimitValue((newAccountSpecial.getBalance() + newAccountSpecial.getLimitValue())
							- account.getBalance());
					newAccountSpecial.setBalance(0);
					accountSpecialService.update(id, newAccountSpecial);
					historicService.instantiateWithdrawToAccountSpecial(account.getBalance(), newAccountSpecial);
					return String.format("Current balance: %.2f\nnCurrent special limit: %.2f",
							newAccountSpecial.getBalance(), newAccountSpecial.getLimitValue());
				} else {
					return String.format("Insufficient balance!\nCurrent balance: %.2f\nnCurrent special limit: %.2f",
							newAccountSpecial.getBalance(), newAccountSpecial.getLimitValue());
				}
			} else {
				newAccountSpecial.setBalance(newAccountSpecial.getBalance() - account.getBalance());
				accountSpecialService.update(id, newAccountSpecial);
				historicService.instantiateWithdrawToAccountSpecial(account.getBalance(), newAccountSpecial);
				return String.format("Current balance: %.2f\nnCurrent special limit: %.2f", newAccountSpecial.getBalance(),
						newAccountSpecial.getLimitValue());
			}
		} else if (myAccount.getTypeAccount().equals("C")) {
			CurrentAccount newAccountCurrent = accountCurrentService.findById(id);
			if (newAccountCurrent.getBalance() - account.getBalance() < 0) {
				return String.format("Insufficient balance!\nCurrent balance: %.2f", newAccountCurrent.getBalance());
			} else {
				newAccountCurrent.setBalance(newAccountCurrent.getBalance() - account.getBalance());
				accountCurrentService.update(id, newAccountCurrent);
				historicService.instantiateWithdrawToAccountCurrent(account.getBalance(), newAccountCurrent);
				return String.format("Current balance: %.2f", newAccountCurrent.getBalance());
			}
		} else {
			return "An error has occurred!\\n Please try again later.";
		}
	}

	public String transfer(Long id, TransferForm form) {

		Account accountDestination = accountService.findById(form.getAccountDestination());
		Account accountOrigin = accountService.findById(id);

		if (accountOrigin.getBalance() - form.getValueToTransfer() < 0) {
			return String.format("Insufficient balance!\nCurrent balance: %.2f", accountOrigin.getBalance());
		} else {
			if (accountDestination.getTypeAccount().equals("C")) {
				CurrentAccount newAccountCurrent = accountCurrentService.findById(accountDestination.getId());
				newAccountCurrent.setBalance(form.getValueToTransfer() + newAccountCurrent.getBalance());
				accountCurrentService.update(newAccountCurrent.getId(), newAccountCurrent);
				historicService.instantiateTransferFromAccountCurrent(form.getValueToTransfer(),
						newAccountCurrent.getId(), newAccountCurrent);
			} else {
				SpecialAccount newAccountSpecial = accountSpecialService.findById(accountDestination.getId());
				newAccountSpecial.setBalance(form.getValueToTransfer() + newAccountSpecial.getBalance());
				accountSpecialService.update(newAccountSpecial.getId(), newAccountSpecial);
				historicService.instantiateTransferFromAccountSpecial(form.getValueToTransfer(),
						newAccountSpecial.getId(), newAccountSpecial);
			}

			if (accountOrigin.getTypeAccount().equals("C")) {
				CurrentAccount newAccountCurrent = accountCurrentService.findById(accountOrigin.getId());
				newAccountCurrent.setBalance(accountOrigin.getBalance() - form.getValueToTransfer());
				accountCurrentService.update(newAccountCurrent.getId(), newAccountCurrent);
				historicService.instantiateTransferToAccountCurrent(form.getValueToTransfer(),
						newAccountCurrent.getId(), newAccountCurrent);
			} else {
				System.err.println("Or S");
				SpecialAccount newAccountSpecial = accountSpecialService.findById(accountOrigin.getId());
				newAccountSpecial.setBalance(accountOrigin.getBalance() - form.getValueToTransfer());
				accountSpecialService.update(newAccountSpecial.getId(), newAccountSpecial);
				historicService.instantiateTransferToAccountSpecial(form.getValueToTransfer(),
						newAccountSpecial.getId(), newAccountSpecial);
			}

			return String.format("Transfer performed successfully!\n Current balance: %.2f",
					accountOrigin.getBalance());
		}
	}
}
