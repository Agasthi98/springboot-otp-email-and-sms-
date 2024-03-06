package org.example.otpemail.service.impl;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.example.otpemail.config.TwilioConfig;
import org.example.otpemail.model.Response.DefaultResponse;
import org.example.otpemail.model.SmsRequest;
import org.example.otpemail.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SmsServiceImpl implements SmsService {

    @Autowired
    private TwilioConfig.TwilioInit twilioInit;


    @Value("${twilo_outing_number}")
    String from_mobile_number;


    @Override
    public DefaultResponse sendSms(SmsRequest smsRequest) {

        String mobile = smsRequest.getMobileNumber();

        String toMobileNo = convertMobileNumber(mobile);

        String otp = generateOTP(6);

        String printMessage = "Hi, Your OTP is: " + otp + ". Please do not share it with anyone.";

        smsRequest.setMessage(printMessage);

        Message message = Message.creator(
                        new PhoneNumber(toMobileNo),
                        new PhoneNumber(from_mobile_number),
                        smsRequest.getMessage())
                .create();

        return new DefaultResponse(200, "Success", message.getStatus().toString());
    }

    private String convertMobileNumber(String number) {
        if (number.length() == 10 && number.startsWith("0")) {
            return "+94" + number.substring(1);
        } else {
            return "Invalid mobile number format";
        }
    }

    private String generateOTP(int length) {
        // Define characters allowed in the OTP
        String numbers = "0123456789";
        Random random = new Random();
        StringBuilder otp = new StringBuilder();

        // Generate OTP of specified length
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            otp.append(numbers.charAt(index));
        }

        return otp.toString();
    }
}
