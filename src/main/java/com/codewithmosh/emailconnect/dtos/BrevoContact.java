package com.codewithmosh.emailconnect.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BrevoContact {

    @SerializedName("email")
    private String email;

    @SerializedName("name")
    private String name;

    // Constructors, Getters, Setters
}
