package org.example.otpemail.controller;

import org.example.otpemail.model.EmailDetails;
import org.example.otpemail.model.Response.DefaultResponse;
import org.example.otpemail.model.SmsRequest;
import org.example.otpemail.service.SmsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/sms")
public class SmsController {

    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public ResponseEntity<DefaultResponse> sendSms(@RequestBody SmsRequest smsRequest) {
        DefaultResponse response =  smsService.sendSms(smsRequest);
        if(response.getStatus() == 200) {
            return ResponseEntity.ok(DefaultResponse.success(response.getTitle(), response.getMessage()));
        }else{
            return ResponseEntity.badRequest().body(DefaultResponse.error(response.getTitle(), response.getMessage()));
        }
    }
}
