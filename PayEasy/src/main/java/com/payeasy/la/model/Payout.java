package com.payeasy.la.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Payout {
	private String account_number;
	private String fund_account_id;
	private Integer amount;
	private String currency;
	private String mode;
	private String purpose;
	private String queue_if_low_balance;
	private String reference_id;
}
