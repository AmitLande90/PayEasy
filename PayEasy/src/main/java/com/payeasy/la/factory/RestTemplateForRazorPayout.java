package com.payeasy.la.factory;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.payeasy.la.model.Contact;
import com.payeasy.la.model.FundAccountRequest;
import com.payeasy.la.model.Payout;

@Component
public class RestTemplateForRazorPayout {
	@Autowired
	AuthorizarionHeader authorizarionHeader;

	public static String url = "https://api.razorpay.com/v1/";
	
	public ResponseEntity<String> createPayout(Payout payout) {
		HttpHeaders headers = new HttpHeaders();
		URI uri = null;
		try {
			uri = new URI(url + "payouts");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		headers.set("Authorization", authorizarionHeader.getAuthorizationString());
		headers.set("Content-Type", "application/json");

		HttpEntity<Payout> request = new HttpEntity<>(payout, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);

		return response;
	}

	public ResponseEntity<String> getAllPayouts(String account_number) {
		HttpHeaders headers = new HttpHeaders();
		URI uri = null;
		try {
			uri = new URI(url + "payouts/account_number="+account_number);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		headers.set("Authorization", authorizarionHeader.getAuthorizationString());
		headers.set("Content-Type", "application/json");

		HttpEntity<Contact> request = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(uri, HttpMethod.GET, request, String.class);		
	}
	
	public ResponseEntity<String> getPayoutById(String id) {
		HttpHeaders headers = new HttpHeaders();
		URI uri = null;
		try {
			uri = new URI(url + "payouts/"+id);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		headers.set("Authorization", authorizarionHeader.getAuthorizationString());
		headers.set("Content-Type", "application/json");

		HttpEntity<Contact> request = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(uri, HttpMethod.GET, request, String.class);		
	}
}
