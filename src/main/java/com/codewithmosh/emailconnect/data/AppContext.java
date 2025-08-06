package com.codewithmosh.emailconnect.data;

import org.springframework.beans.factory.annotation.Value;

import java.nio.file.Paths;

public class AppContext {
    @Value("${spring.brevo.attachmentPath}")
    public static String attachmentPath;

    public static String attachmentName = Paths.get(attachmentPath).getFileName().toString();
}
