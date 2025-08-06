package com.codewithmosh.emailconnect.mappers;

import com.codewithmosh.emailconnect.dtos.ContactDto;
import com.codewithmosh.emailconnect.dtos.SendEmailRequest;
import com.codewithmosh.emailconnect.entities.Contact;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactDto toDto(Contact contact);

    Contact toEntity(SendEmailRequest emailRequest);

}
