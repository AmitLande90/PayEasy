package com.payeasy.la.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payeasy.la.factory.RestTemplateForRazorContact;
import com.payeasy.la.model.Contact;

@RestController
public class ContactController {

	@Autowired
	RestTemplateForRazorContact restTemplate;

	@PostMapping("/create_contact")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> createContact(@RequestHeader Map<String, String> headers,
			@RequestBody Contact contact) {
		return restTemplate.createContact(contact);
	}
	
	@PatchMapping("/update_contact/{id}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<String> updareContact(@RequestHeader Map<String, String> headers,
			@RequestBody Contact contact, @PathVariable String id){
			
		return restTemplate.updateContact(id, contact);
	}
	
	@GetMapping("/getAll_contacts")
	public ResponseEntity<String> getAllContacts(@RequestHeader Map<String, String> headers){
			
		return restTemplate.getAllContacts();
	}
	
	@GetMapping("/get_contact/{id}")
	public ResponseEntity<String> getContactById(@RequestHeader Map<String, String> headers,
			@PathVariable String id){
			
		return restTemplate.getContactById(id);
	}
}
