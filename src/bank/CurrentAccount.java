package bank;

import person.Client;

public class CurrentAccount extends Account {

	public CurrentAccount(Agency agency, Client client) {
		super(agency, client);
	}

	@Override
	public void moneyWithdraw(double value, Account account) {
		if (this.balance > 0) {
			this.balance -= value;
			System.out.printf("\nWithdrawal was successful!\nThe account balance is: $ %.2f\n", this.balance);
			String message = String.format("\nWithdrawal from:\t$ %.2f.\tCurrent balance:\t$ %.2f.", value,
					this.balance);
			this.generateExtract(account, message);
		} else {
			System.err.println(
					"\nOperation not allowed!\nThe balance in your account is less than the amount you want to withdraw!");
		}
	}
}
