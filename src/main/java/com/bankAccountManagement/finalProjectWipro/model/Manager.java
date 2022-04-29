package com.bankAccountManagement.finalProjectWipro.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Manager extends Person {
	@OneToOne
	private Agency agency;

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

}
