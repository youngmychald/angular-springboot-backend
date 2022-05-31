package com.ensono.challange.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 

import com.ensono.challange.exception.ResourceNotFoundException;
import com.ensono.challange.persistence.Contact;
import com.ensono.challange.repository.ContactRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ContactController {

	@Autowired
	private ContactRepository contactRepository;

	/**
	 * Get all contacts
	 * 
	 * @return
	 */
	
	@GetMapping("/contacts")
	public List<Contact> getAllEmployees() 
	{
		return contactRepository.findAll();
	}

	/**
	 * Creates a new contact record and persist it.
	 * 
	 * @return The persisted Contact record.
	 */
	
	// @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/contacts")
	public Contact createEmployee(@RequestBody Contact contact) 
	{
		return contactRepository.save(contact);
	}
	
	/**
	 * Get a contact by ID.
	 *
	 * @param id Contact ID.
	 * @return Contact.
	 */
	
	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getEmployeeById(@PathVariable Long id) 
	{
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Unable to find Contact for id :" + id));
		return ResponseEntity.ok(contact);
	}

	/**
	 * Update a contact by ID.
	 *
	 * @param ContactDTO ID.
	 * @param Contact object from the request body.
	 * @return The updated Contact.
	 */
	
	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) 
	{
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contact Id in request body does not match id in URI :" + id));

		contact.setFirstName(contactDetails.getFirstName());
		contact.setLastName(contactDetails.getLastName());
		contact.setAddress(contactDetails.getAddress());
		contact.setEmailId(contactDetails.getEmailId());
		contact.setPhoneNumber(contactDetails.getPhoneNumber());
		contact.setDateOfBirth(contactDetails.getDateOfBirth());

		Contact updatedContact = contactRepository.save(contact);
		return ResponseEntity.ok(updatedContact);
	}

	/**
	 * Delete a contact by ID.
	 *
	 * @param id Contact ID.
	 * @return Deleted Contact object.
	 */
	
	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) 
	{
		Contact contact = contactRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Unable to find Employee for id :" + id));

		contactRepository.delete(contact);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
