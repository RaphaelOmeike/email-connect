package com.codewithmosh.emailconnect.services;

import com.codewithmosh.emailconnect.dtos.ContactDto;
import com.codewithmosh.emailconnect.dtos.SendEmailRequest;
import com.codewithmosh.emailconnect.mappers.ContactMapper;
import com.codewithmosh.emailconnect.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactService {
    private final ContactMapper contactMapper;
    private final ContactRepository contactRepository;

    public ContactDto createContact(SendEmailRequest request) {
        var contact = contactMapper.toEntity(request);
        contactRepository.save(contact);
        // Logic to create a contact
        // This could involve saving the contact to a database or performing other operations
        return contactMapper.toDto(contact); // Return the created contact DTO
    }
}
