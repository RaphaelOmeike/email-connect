package com.codewithmosh.emailconnect.controllers;

import com.codewithmosh.emailconnect.dtos.ContactDto;
import com.codewithmosh.emailconnect.dtos.SendEmailRequest;
import com.codewithmosh.emailconnect.services.BrevoEmailService;
import com.codewithmosh.emailconnect.services.ContactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/contacts")
@RestController
public class ContactController {
    private final BrevoEmailService emailService;
    private final ContactService contactService;

    @PostMapping("/send-email")
    public ResponseEntity<ContactDto> sendEmail(@Valid @RequestBody SendEmailRequest request) {
        emailService.sendEmailWithAttachment(request);
        var response = contactService.createContact(request);
        return ResponseEntity.ok(response);

    }


    @GetMapping("/sample")
    public ResponseEntity<SendEmailRequest> getSampleRequest() {
        SendEmailRequest request = new SendEmailRequest();
        request.setFirstName("John");
        request.setLastName("Doe");
        request.setEmail("john.doe@example.com");
        request.setCompanyAddress("123 Java Avenue, Spring City");

        return ResponseEntity.ok(request);
    }


}
