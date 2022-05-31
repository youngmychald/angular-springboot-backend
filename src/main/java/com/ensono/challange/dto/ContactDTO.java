package com.ensono.challange.dto;

//import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.ensono.challange.persistence.Contact;

import java.time.LocalDate;

public class ContactDTO {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String emailId;
	private String address;
	private String phoneNumber;
	private LocalDate dateOfBirth;
	
	public ContactDTO() 
	{
		
	}
	
	
	/**
	 * This constructor take the contact entity object and converts it to a ContactDTO.
	 * 
	 * 
	 * @param contact contact entity object
	 */
	
//	public ContactDTO(Contact contact) 
//	{
//		this.id = contact.getId();
//		this.firstName = contact.getFirstName();
//		this.lastName = contact.getLastName();
//		this.emailId = contact.getEmailId();
//		this.address = contact.getAddress();
//		this.phoneNumber = contact.getPhoneNumber();
//		this.dateOfBirth = contact.getDateOfBirth();
//	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
}
