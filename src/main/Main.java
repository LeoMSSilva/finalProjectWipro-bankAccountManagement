package main;
import bank.CreditCard;
import person.Client;

public class Main {
	public static void main(String[] args) {
		Client client = new Client();
		CreditCard card = new CreditCard(client);
		System.out.println(card.getCardNumbering());
	}
}
