package com.codewithmosh.emailconnect.repositories;

import com.codewithmosh.emailconnect.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Custom query methods can be defined here if needed
}
