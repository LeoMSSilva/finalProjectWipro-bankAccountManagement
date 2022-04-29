package com.bankAccountManagement.finalProjectWipro.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bankAccountManagement.finalProjectWipro.model.enums.HistoricType;


@Entity
public class Historic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long accountNumberOrigin;
	private Long accountNumberDestiny;
	private LocalDateTime historicData = LocalDateTime.now();
	private HistoricType historicType;
	private double movedValue;
	@ManyToOne
	private Account account;

	public Historic() {
	}

	public Historic(HistoricType historicType, double movedValue, Account account) {
		this.historicType = historicType;
		this.movedValue = movedValue;
		this.account = account;
	}

	public Historic(HistoricType historicType, double movedValue, Account account, Long accountNumberOrigin) {
		this.accountNumberOrigin = accountNumberOrigin;
		this.historicType = historicType;
		this.movedValue = movedValue;
		this.account = account;
	}

	public Historic(Long accountNumberDestiny, HistoricType historicType, double movedValue, Account account) {
		this.accountNumberDestiny = accountNumberDestiny;
		this.historicType = historicType;
		this.movedValue = movedValue;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNumberOrigin() {
		return accountNumberOrigin;
	}

	public void setAccountNumberOrigin(Long accountNumberOrigin) {
		this.accountNumberOrigin = accountNumberOrigin;
	}

	public Long getAccountNumberDestiny() {
		return accountNumberDestiny;
	}

	public void setAccountNumberDestiny(Long accountNumberDestiny) {
		this.accountNumberDestiny = accountNumberDestiny;
	}

	public LocalDateTime getHistoric_data() {
		return historicData;
	}

	public void setHistoric_data(LocalDateTime historicData) {
		this.historicData = historicData;
	}

	public HistoricType getHistoricType() {
		return historicType;
	}

	public void setHistoricType(HistoricType historicType) {
		this.historicType = historicType;
	}

	public double getMovedValue() {
		return movedValue;
	}

	public void setMovedValue(double movedValue) {
		this.movedValue = movedValue;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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
		Historic other = (Historic) obj;
		return id == other.id;
	}
}
