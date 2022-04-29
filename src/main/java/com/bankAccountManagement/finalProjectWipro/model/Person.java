package com.bankAccountManagement.finalProjectWipro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Person", description = "Person Model")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
	@ApiModelProperty(hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ApiModelProperty(value = "cpf", example = "12345678910", required = true)
	private String cpf;
	@ApiModelProperty(value = "name", example = "Jhon", required = true)
	private String name;
	@ApiModelProperty(value = "address", example = "901 Chapala St", required = true)
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Person person = (Person) o;

		return id.equals(person.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
