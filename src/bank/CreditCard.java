package bank;

import java.util.Random;

import person.Client;

public class CreditCard {
	private String cardNumbering;
	private String CVV;
	private Client client;

	public CreditCard(Client client) {
		Random random = new Random();
		this.cardNumbering = "";
		for (int i = 0; i < 16; i++) {
			this.cardNumbering += random.nextInt(10);
		}
		for (int i = 0; i < 3; i++) {
			this.CVV += random.nextInt(10);
		}
		this.client = client;
	}

	public String getCardNumbering() {
		return cardNumbering;
	}

	public String getCVV() {
		return CVV;
	}

	public Client getClient() {
		return client;
	}
}
