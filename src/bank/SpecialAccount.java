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
	public void moneyWithdraw(double value, Account account) {
		if (this.balance + limit <= value) {
			this.balance -= value;
			System.out.printf("\nWithdrawal was successful!\nThe account balance is: $ %.2f\n", this.balance);
			String message = "\nWithdrawal from:\t$ " + value + "0.\tCurrent balance:\t$ " + this.balance + "0.";
			this.generateExtract(account, message);
		} else {
			System.err.println(
					"\nOperation not allowed!\nThe amount you want to withdraw is greater than the amount of your balance plus the limit in your account!");
		}
	}
}
