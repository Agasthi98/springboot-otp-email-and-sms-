package org.example.otpemail.config;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwilioConfig {

    @Value("${twilo_account_sid}")
    private String accountSid;

    @Value("${twilo_auth_token}")
    private String authToken;

    @Bean
    public TwilioInit twilioInitializer() {
        return new TwilioInit(accountSid, authToken);
    }

    public static class TwilioInit {
        public TwilioInit(String accountSid, String authToken) {
            Twilio.init(accountSid, authToken);
        }
    }
}
