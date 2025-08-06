package com.codewithmosh.emailconnect.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BrevoSender {
    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

}
