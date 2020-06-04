package com.payeasy.la.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FundAccountRequest {
	@JsonProperty("contact_id")
	private String contact_id;
	@JsonProperty("account_type")
	private String account_type;
	@JsonProperty("bank_account")
	private BankAccount bank_account;
	private Boolean active;
}
