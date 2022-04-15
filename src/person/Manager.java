package person;

import java.util.Scanner;

import bank.Account;

public class Manager extends Person {
	public Manager(String name, String address) {
		super(name, address);
	}

	public void updateAccountData(Account account) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What would you like to change?\n1 - registered customer name\n2 - address:");
		String response = scanner.nextLine();
		switch (response) {
		case "1":
			System.out.println("Enter customer name to update:");
			response = scanner.nextLine();
			account.getClient().setName(response);
			System.out.println("Customer name has been updated successfully!");
			break;
		case "2":
			System.out.println("Enter customer address to update:");
			response = scanner.nextLine();
			account.getClient().setAddress(response);
			System.out.println("Customer address has been updated successfully!");
			break;
		default:
			System.out.println("Incorrect operation!\nPlease enter a valid option!");
			break;
		}
		scanner.close();
	}

	public void deleteAccount(Account account) {
		account.setStatus(false);
		System.out.println("Account closed successfully!");
	}

}
