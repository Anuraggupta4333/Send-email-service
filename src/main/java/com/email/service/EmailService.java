package com.email.service;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {
    public boolean sendEmail(String subject, String message, String to) {
        boolean f=false;
        // Implementation to send email
        String from = "anurag4102001@gmail.com";
        // Variable for Gmail
        String host = "smtp.gmail.com";

        // Get the system properties
        Properties properties = System.getProperties();
        System.out.println("Properties: " + properties);

        // Setting important information to properties object
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");  // Updated to 587 for TLS
        properties.put("mail.smtp.starttls.enable", "true");  // Enable STARTTLS
        properties.put("mail.smtp.auth", "true");

        // Get session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // Using environment variable for password
                return new PasswordAuthentication("anurag4102001@gmail.com", "vulg bnmi gywd teyt");
            }
        });
        session.setDebug(true);

        MimeMessage m = new MimeMessage(session);
        try {
            // From email
            m.setFrom(from);

            // Adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Adding subject to message
            m.setSubject(subject);

            // Adding message
            m.setText(message);

            // Send email
            Transport.send(m);
            System.out.println("Sent successfully");
            f = true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return f;
    }
}