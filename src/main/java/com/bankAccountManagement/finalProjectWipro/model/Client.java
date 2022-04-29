package com.bankAccountManagement.finalProjectWipro.model;

import javax.persistence.Entity;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "Client", description = "Client Model")
@Entity
public class Client extends Person {

}
