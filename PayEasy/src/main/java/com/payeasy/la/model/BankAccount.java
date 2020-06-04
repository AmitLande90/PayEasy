package com.payeasy.la.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BankAccount {
	@JsonProperty("name")
	private String name;
	@JsonProperty("ifsc")
	private String ifsc;
	@JsonProperty("account_number")
	private String account_number;
}
