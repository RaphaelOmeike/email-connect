package com.codewithmosh.emailconnect.data;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

@Component
public class AppContext {

    @Value("${spring.brevo.attachmentPath}")
    private String injectedAttachmentPath;

    @Getter
    private static String attachmentPath;
    @Getter
    private static String attachmentName;

    @PostConstruct
    public void init() {
        attachmentPath = injectedAttachmentPath;
        attachmentName = Paths.get(attachmentPath).getFileName().toString();
    }

}
