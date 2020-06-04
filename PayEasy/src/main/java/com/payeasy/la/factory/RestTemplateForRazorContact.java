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

@Component
public class RestTemplateForRazorContact {

	@Autowired
	AuthorizarionHeader authorizarionHeader;

	public static String url = "https://api.razorpay.com/v1/";

	public ResponseEntity<String> createContact(Contact contact) {
		HttpHeaders headers = new HttpHeaders();
		URI uri = null;
		try {
			uri = new URI(url + "contacts");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		headers.set("Authorization", authorizarionHeader.getAuthorizationString());
		headers.set("Content-Type", "application/json");

		HttpEntity<Contact> request = new HttpEntity<>(contact, headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
		return response;
	}

	public ResponseEntity<String> updateContact(String id, Contact contact) {
		HttpHeaders headers = new HttpHeaders();
		URI uri = null;
		try {
			uri = new URI(url + "contacts/" + id);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		headers.set("Authorization", authorizarionHeader.getAuthorizationString());
		headers.set("Content-Type", "application/json");

		HttpEntity<Contact> request = new HttpEntity<>(contact, headers);
		RestTemplate restTemplate = new RestTemplate();
		// restTemplate.put(uri, request);
		// String response = restTemplate.patchForObject(uri, request, String.class);
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.PATCH, request, String.class);
		return response;
	}

	public ResponseEntity<String> getAllContacts() {
		HttpHeaders headers = new HttpHeaders();
		URI uri = null;
		try {
			uri = new URI(url + "contacts");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		headers.set("Authorization", authorizarionHeader.getAuthorizationString());
		headers.set("Content-Type", "application/json");

		HttpEntity<Contact> request = new HttpEntity<>(headers);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(uri, HttpMethod.GET, request, String.class);		
	}
	
	public ResponseEntity<String> getContactById(String id) {
		HttpHeaders headers = new HttpHeaders();
		URI uri = null;
		try {
			uri = new URI(url + "contacts/"+id);
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
