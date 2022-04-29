package com.bankAccountManagement.finalProjectWipro.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CreditCard", description = "CreditCard Model")
@Entity
public class CreditCard {

	@ApiModelProperty(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(value = "cardNumbering", example = "123456789", required = true)
	private String cardNumbering;
	@ApiModelProperty(value = "cvv", example = "789", required = true)
	private String cvv;
	@ApiModelProperty(value = "creditLimit", example = "1000.00", required = true)
	private double creditLimit;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumbering;
	}

	public void setCardNumber(String cardNumbering) {
		this.cardNumbering = cardNumbering;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public double getCredit_limit() {
		return creditLimit;
	}

	public void setCredit_limit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreditCard other = (CreditCard) obj;
		return id == other.id;
	}

}
