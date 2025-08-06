package com.codewithmosh.emailconnect.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BrevoAttachment {

    @SerializedName("content")
    private String content; // Base64-encoded

    @SerializedName("name")
    private String name;

    // Constructors, Getters, Setters
}
