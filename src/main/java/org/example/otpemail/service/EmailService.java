package org.example.otpemail.service;

import org.example.otpemail.model.EmailDetails;
import org.example.otpemail.model.Response.DefaultResponse;

public interface EmailService {
    // Method
    // To send a simple email
    DefaultResponse sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
