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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payeasy.la.factory.RestTemplateForRazorPayout;
import com.payeasy.la.model.Payout;

@RestController
public class PayoutController {
	@Autowired
	RestTemplateForRazorPayout restTemplate;
	
	@PostMapping("/create_payouts")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> createPayout(@RequestHeader Map<String, String> headers,
			@RequestBody Payout payout) {
		/*
		 * headers.forEach((key, value)->System.out.println(key +" "+value)); String[]
		 * encodedAuthorizationString = headers.get("authorization").split("Basic ");
		 * byte[] bytes = Base64.decodeBase64(encodedAuthorizationString[1].getBytes());
		 * String decoded = new String(bytes.toString());
		 * System.out.println("Decoded string: "+decoded);
		 * System.out.println(fundAccount.toString());
		 */

		return restTemplate.createPayout(payout);

	}
	
	@GetMapping("/getAll_payouts")
	public ResponseEntity<String> getAllContacts(@RequestHeader Map<String, String> headers,@RequestParam String account_number){
			
		return restTemplate.getAllPayouts(account_number);
	}
	
	@GetMapping("/get_payout/{id}")
	public ResponseEntity<String> getContactById(@RequestHeader Map<String, String> headers,
			@PathVariable String id){
			
		return restTemplate.getPayoutById(id);
	}
}
