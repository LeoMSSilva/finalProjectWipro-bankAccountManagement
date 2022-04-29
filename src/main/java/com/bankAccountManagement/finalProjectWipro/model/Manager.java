package com.bankAccountManagement.finalProjectWipro.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Manager", description = "Manager Model")
@Entity
public class Manager extends Person {
	@ApiModelProperty(value = "id", example = "1", required = true)
	@OneToOne
	private Agency agency;

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

}
