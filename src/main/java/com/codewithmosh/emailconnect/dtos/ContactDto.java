package com.codewithmosh.emailconnect.dtos;

import lombok.Data;

@Data
public class ContactDto {
    private String id;
    private String firstName;

    private String lastName;

    private String email;

    private String companyAddress;
}
