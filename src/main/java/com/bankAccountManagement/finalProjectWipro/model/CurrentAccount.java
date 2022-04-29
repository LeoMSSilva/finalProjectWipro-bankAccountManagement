package com.bankAccountManagement.finalProjectWipro.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Current Account", description = "Current Account Model")
@Entity
@DiscriminatorValue(value = "C")
public class CurrentAccount extends Account {

	@Override
	public String toString() {
		return "AccountCurrent{} " + super.toString();
	}
}