package bank;

import person.Client;

public class SpecialAccount extends Account {

	private double limit;

	public SpecialAccount(Agency agency, Client client) {
		super(agency, client);
		this.limit = 500.00;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	@Override
	public void consultAccountData(Account account) {
		System.out.printf(
				"\nAgency: %s - %s\nAccount number: %s\nStatus: %s\nBalance: $ %.2f\nLimit: $ %.2f\nAccount credit card: %s\nClient: %s\n",
				account.getAgency().getAgencyNumber(), account.getAgency().getAgencyName(), account.getNumber(),
				account.getStatus(), account.getBalance(), getLimit(), account.getCreditCrad().getCardNumbering(),
				account.getClient().getName());
	}

	@Override
	public void moneyWithdraw(double value, Account account) {
		if (value <= (this.balance > 0 ? this.balance : this.balance + limit)) {
			this.balance -= value;
			System.out.printf("\nWithdrawal was successful!\nThe account balance is: $ %.2f\n", this.balance);
			String message = String.format("\nWithdrawal from:\t$ %.2f.\tCurrent balance:\t$ %.2f", value,
					this.balance);
			this.generateExtract(account, message);
		} else {
			System.err.println(
					"\nOperation not allowed!\nThe amount you want to withdraw is greater than the amount of your balance plus the limit in your account!");
		}
	}
}
