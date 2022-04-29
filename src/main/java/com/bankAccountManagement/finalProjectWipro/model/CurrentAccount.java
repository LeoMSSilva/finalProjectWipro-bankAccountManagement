package com.bankAccountManagement.finalProjectWipro.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
public class CurrentAccount extends Account {

	@Override
	public String toString() {
		return "AccountCurrent{} " + super.toString();
	}
}