package com.neko.pushnotification.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PushNotificationRequest {

    private String title;

    private String message;

    private String topic;

    private String token;
}
