package org.example.otpemail.service;

import org.example.otpemail.model.Response.DefaultResponse;
import org.example.otpemail.model.SmsRequest;

public interface SmsService {

    DefaultResponse sendSms(SmsRequest smsRequest);
}
