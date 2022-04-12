package bank;

public class CreditCard {
	
	private int cardNumber;
	private double limit;
	
	public CreditCard(int cardNumber){
		this.cardNumber = cardNumber;
		this.limit = 400;
	}
	
	public int getCardNumber() {
		return cardNumber;
	}

	public double getLimit() {
		return limit;
	}
	
	public void setLimit(double limit) {
		this.limit = limit;
	}	
}
