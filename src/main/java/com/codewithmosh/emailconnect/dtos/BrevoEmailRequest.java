package com.codewithmosh.emailconnect.dtos;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BrevoEmailRequest {

    @SerializedName("sender")
    private BrevoSender sender;

    @SerializedName("replyTo")
    private BrevoSender replyTo;

    @SerializedName("to")
    private List<BrevoContact> to;

    @SerializedName("subject")
    private String subject;

    @SerializedName("htmlContent")
    private String htmlContent;


    @SerializedName("attachment")
    private List<BrevoAttachment> attachment;

    // Constructors, Getters, Setters
}
