package person;

import java.util.Random;

import bank.Account;
import utils.Files;

public abstract class Person {
	private int id;
	private String cpf;
	private String address;
	private String name;

	public Person(String name, String address) {
		Random random = new Random();
		this.id = random.nextInt(100);
		for (int i = 0; i < 11; i++) {
			this.cpf += random.nextInt(10);
		}
		this.address = address;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void consultExtract(Account account) {
		String divisor = "===========================================================================";
		System.out.printf("\n%s\n\t\t\t\tBank Statement\n%s\n", divisor, divisor);
		String file = account.getNumber() + ".log";
		Files files = new Files();
		files.read(file);
		System.out.println(divisor);
	}
}
