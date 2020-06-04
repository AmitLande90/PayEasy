package com.payeasy.la.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payeasy.la.factory.RestTemplateForRazorFundAccount;
import com.payeasy.la.model.FundAccountRequest;

@RestController
public class FundAccountController {

	@Autowired
	RestTemplateForRazorFundAccount restTemplate;

	@PostMapping("/create_fund_account")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> createFundAccount(@RequestHeader Map<String, String> headers,
			@RequestBody FundAccountRequest fundAccount) {
		/*
		 * headers.forEach((key, value)->System.out.println(key +" "+value)); String[]
		 * encodedAuthorizationString = headers.get("authorization").split("Basic ");
		 * byte[] bytes = Base64.decodeBase64(encodedAuthorizationString[1].getBytes());
		 * String decoded = new String(bytes.toString());
		 * System.out.println("Decoded string: "+decoded);
		 * System.out.println(fundAccount.toString());
		 */

		return restTemplate.createFundAccount(fundAccount);

	}
	
	@GetMapping("/getAll_fundAccounts")
	public ResponseEntity<String> getAllContacts(@RequestHeader Map<String, String> headers){
			
		return restTemplate.getAllFundAccounts();
	}
	
	@GetMapping("/get_fundAccount/{id}")
	public ResponseEntity<String> getContactById(@RequestHeader Map<String, String> headers,
			@PathVariable String id){
			
		return restTemplate.getFundAccountById(id);
	}
	
}
