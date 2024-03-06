package org.example.otpemail.model.Response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Setter
@Getter
public class DefaultResponse {
    private int status;
    private String title;
    private String message;

    public DefaultResponse(int status, String title, String message) {
        this.status = status;
        this.title = title;
        this.message = message;
    }
    public static DefaultResponse success(String title, String message) {
        return new DefaultResponse(200, title, message);
    }

    public static DefaultResponse error(String title, String message) {
        return new DefaultResponse(400, title, message);
    }
}
