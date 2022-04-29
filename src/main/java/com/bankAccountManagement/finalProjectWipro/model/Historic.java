package com.bankAccountManagement.finalProjectWipro.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bankAccountManagement.finalProjectWipro.model.enums.HistoricType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Historic", description = "Historic Model")
@Entity
public class Historic {

	@ApiModelProperty(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(value = "accountNumberOrigin", example = "1", required = true)
	private Long accountNumberOrigin;
	@ApiModelProperty(value = "accountNumberDestiny", example = "2", required = true)
	private Long accountNumberDestiny;
	@ApiModelProperty(value = "historicData", example = "2022-04-29", required = true)
	private LocalDateTime historicData = LocalDateTime.now();
	@ApiModelProperty(value = "historicType", example = "deposit", required = true)
	private HistoricType historicType;
	@ApiModelProperty(value = "movedValue", example = "1000.00", required = true)
	private double movedValue;
	@ApiModelProperty(value = "id", example = "1", required = true)
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
