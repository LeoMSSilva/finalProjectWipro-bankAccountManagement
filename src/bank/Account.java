package bank;

import java.util.Random;

import person.Client;
import utils.Files;

public abstract class Account {
	private String number;
	protected double balance;
	private boolean status;
	private CreditCard creditCrad;
	private Agency agency;
	private Client client;

	public Account(Agency agency, Client client) {
		Random random = new Random();
		this.number = "";
		for (int i = 0; i < 7; i++) {
			this.number += random.nextInt(10);
		}
		this.number += "-" + random.nextInt(10);
		this.balance = 0;
		this.status = true;
		this.client = client;
		this.creditCrad = new CreditCard(this.client);
		this.agency = agency;
	}

	public String getNumber() {
		return number;
	}

	public double getBalance() {
		return balance;
	}

	public String getStatus() {
		return status ? "enabled" : "disabled";
	}

	public CreditCard getCreditCrad() {
		return creditCrad;
	}

	public Agency getAgency() {
		return agency;
	}

	public Client getClient() {
		return client;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void generateExtract(Account account, String textForFile) {
		String file = account.getNumber() + ".log";
		Files files = new Files();
		files.write(file, textForFile);
	}

	public void consultAccountData(Account account) {
		System.out.printf(
				"Agency: %s - %s\nAccount number: %s\nStatus: %s\nBalance: $ %.2f\nAccount credit card: %s\nClient: %s\n",
				account.getAgency().getAgencyNumber(), account.getAgency().getAgencyName(), account.getNumber(),
				account.getStatus(), account.getBalance(), account.getCreditCrad().getCardNumbering(),
				account.getClient().getName());
	}

	public void moneyDeposit(double value, Account account) {
		if (value <= 0) {
			System.err.println("\nOperation not allowed!\nThe deposit amount cannot be negative!");
		} else {
			this.balance += value;
			System.out.printf("\nSuccessfully deposited!\nYour balance is: $ %.2f\n", this.balance);
			String message = "\nDeposit of:\t$ " + value + "0.\tCurrent balance:\t$ " + this.balance + "0.";
			generateExtract(account, message);
		}
	};

	public abstract void moneyWithdraw(double value, Account account);
}
