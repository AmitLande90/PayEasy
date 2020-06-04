package com.payeasy.la.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Contact {
	private String name;
	private String contact;
	private String email;
	private boolean active;
}
