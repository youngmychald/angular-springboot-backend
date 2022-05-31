package com.ensono.challange.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.ensono.challange.persistence.Contact;

@Repository
public interface ContactRepository  extends JpaRepository<Contact, Long> {

}
