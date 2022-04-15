package bank;

import java.util.Random;

public class Agency {
	private String CNPJ;
	private String agencyNumber;
	private String agencyName;

	public Agency(String agencyName) {
		Random random = new Random();
		this.CNPJ = "";
		for (int i = 0; i < 10; i++) {
			this.CNPJ += random.nextInt(10);
		}
		this.agencyNumber = "";
		for (int i = 0; i < 4; i++) {
			this.agencyNumber += random.nextInt(10);
		}
		this.agencyName = agencyName;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public String getAgencyNumber() {
		return agencyNumber;
	}

	public String getAgencyName() {
		return agencyName;
	}

}
