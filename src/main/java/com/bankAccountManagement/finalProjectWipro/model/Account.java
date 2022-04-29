package com.bankAccountManagement.finalProjectWipro.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Account", description = "Account Model")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeAccount", length = 1, discriminatorType = DiscriminatorType.STRING)
public class Account {

	@ApiModelProperty(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(value = "number", example = "123456789", required = true)
	private String number;
	@ApiModelProperty(value = "balance", example = "100.00", required = true)
	private double balance;
	@ApiModelProperty(value = "typeAccount", example = "C", required = true)
	@Column(insertable = false, updatable = false)
	private String typeAccount;
	@ApiModelProperty(value = "client", example = "1", required = true)
	@OneToOne
	private Client client;
	@ApiModelProperty(value = "agency", example = "1", required = true)
	@ManyToOne
	private Agency agency;
	@ApiModelProperty(value = "id", example = "1", required = true)
	@OneToOne
	private CreditCard creditCard;

	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", number='" + number + '\'' + ", balance=" + balance + ", typeAccount='"
				+ typeAccount + '\'' + ", client=" + client + ", agency=" + agency + '}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
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
		Account other = (Account) obj;
		return id == other.id;
	}
}