package org.example.otpemail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsRequest {
    @JsonProperty("mobile_number")
    private String mobileNumber;
    private String message;
}
