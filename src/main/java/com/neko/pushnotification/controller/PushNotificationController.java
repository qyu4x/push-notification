package com.neko.pushnotification.controller;

import com.neko.pushnotification.model.request.PushNotificationRequest;
import com.neko.pushnotification.model.response.WebResponse;
import com.neko.pushnotification.model.response.PushNotificationResponse;
import com.neko.pushnotification.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/")
public class PushNotificationController {

    private final PushNotificationService pushNotificationService;

    @Autowired
    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/notification/token")
    public ResponseEntity<?> pushNotification(@RequestBody PushNotificationRequest pushNotificationRequest) {
        try {
            pushNotificationService.sendPushNotificationToToken(pushNotificationRequest);
            return new ResponseEntity<>(
                    new WebResponse<PushNotificationResponse>(
                            HttpStatus.OK.value(),
                            HttpStatus.OK.getReasonPhrase(),
                            new PushNotificationResponse(
                                    pushNotificationRequest.getTitle(),
                                    pushNotificationRequest.getMessage(),
                                    pushNotificationRequest.getToken()
                            )
                    ),
                    HttpStatus.OK
            );
        }catch (Exception exception) {
            return new ResponseEntity<>(
                    new WebResponse<String>(
                            HttpStatus.INTERNAL_SERVER_ERROR.value(),
                            HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                            exception.getMessage()

                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
