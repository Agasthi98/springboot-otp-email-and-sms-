package org.example.otpemail.controller;

import org.example.otpemail.model.EmailDetails;
import org.example.otpemail.model.Response.DefaultResponse;
import org.example.otpemail.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    // Sending a simple Email
    @PostMapping("/send")
    public ResponseEntity<DefaultResponse> sendMail(@RequestBody EmailDetails details) {
        DefaultResponse response =  emailService.sendSimpleMail(details);
        if(response.getStatus() == 200) {
            return ResponseEntity.ok(DefaultResponse.success(response.getTitle(), response.getMessage()));
        }else{
            return ResponseEntity.badRequest().body(DefaultResponse.error(response.getTitle(), response.getMessage()));
        }
    }

    // Sending email with attachment
    @PostMapping("/sendWith-attachment")
    public String sendMailWithAttachment(@RequestBody EmailDetails details)
    {
        String status = emailService.sendMailWithAttachment(details);
        return status;
    }
}
