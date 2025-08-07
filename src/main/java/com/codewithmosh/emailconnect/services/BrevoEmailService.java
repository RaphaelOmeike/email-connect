package com.codewithmosh.emailconnect.services;

import com.codewithmosh.emailconnect.data.AppContext;
import com.codewithmosh.emailconnect.dtos.*;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BrevoEmailService {

    @Value("${spring.brevo.apiKey}")
    private String API_KEY;

    @Value("${spring.brevo.baseUrl}")
    private String API_URL;

    @Value("${spring.brevo.senderEmail}")
    private String SENDER_EMAIL;

    @Value("${spring.brevo.senderName}")
    private String SENDER_NAME;

    private final FileStorageService fileService;

    public void sendEmailWithAttachment(SendEmailRequest emailRequest) {
        try {
            String url = API_URL + "/smtp/emails";
            Gson gson = new Gson();

            String encodedFile = fileService.encodeFileToBase64(AppContext.attachmentPath);
            String attachmentName= AppContext.attachmentName;
            BrevoAttachment attachment = new BrevoAttachment(encodedFile, attachmentName);

            var request = new BrevoEmailRequest(
                    new BrevoSender(SENDER_NAME, SENDER_EMAIL),
                    new BrevoSender(SENDER_NAME, "no-reply@quidax.com"),
                    List.of(new BrevoContact(emailRequest.getFirstName() + " " + emailRequest.getLastName(), emailRequest.getEmail())),
                    "Thanks for contacting us",
                    "<html>" +
                    "<body>" +
                    "<h2>Contact Information</h2>" +
                    "<p><strong>First Name:</strong> " + emailRequest.getFirstName() + "</p>" +
                    "<p><strong>Last Name:</strong> " + emailRequest.getLastName() + "</p>" +
                    "<p><strong>Email:</strong> " + emailRequest.getEmail() + "</p>" +
                    "<p><strong>Company Address:</strong> " + emailRequest.getCompanyAddress() + "</p>" +
                    "</body>" +
                    "</html>",
                    List.of(attachment)
            );
            String jsonRequest = gson.toJson(request);
            HttpRequest postRequest = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("accept", "application/json")
                    .header("api-key", API_KEY)
                    .header("content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();


            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

//            var response = gson.fromJson(postResponse.body(), .class);
//            return response; //not sure
        }
        catch (Exception ex) {
            System.out.println("Error: Failed to create Quidax sub-account.");
            System.out.println(ex.getMessage());
        }
    }
}
