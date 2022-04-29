package com.bankAccountManagement.finalProjectWipro.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Special Account", description = "Special Account Model")
@Entity
@DiscriminatorValue(value = "S")
public class SpecialAccount extends Account {
	@ApiModelProperty(value = "limitValue", example = "100.00", required = true)
	private double limitValue;

	public double getLimitValue() {
		return limitValue;
	}

	public void setLimitValue(double limitValue) {
		this.limitValue = limitValue;
	}

}