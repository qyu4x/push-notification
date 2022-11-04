package com.neko.pushnotification.service;

import com.neko.pushnotification.model.request.PushNotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class PushNotificationService {

    private final FirebaseCloudMessageingService firebaseCloudMessageingService;

    @Autowired
    public PushNotificationService(FirebaseCloudMessageingService firebaseCloudMessageingService) {
        this.firebaseCloudMessageingService = firebaseCloudMessageingService;
    }

    public void sendPushNotification(PushNotificationRequest request) {
        try {
            firebaseCloudMessageingService.sendMessage(getSamplePayloadData(), request);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void sendPushNotificationWithoutData(PushNotificationRequest request) {
        try {
            firebaseCloudMessageingService.sendMessageWithoutData(request);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            firebaseCloudMessageingService.sendMessageToToken(request);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }


    private Map<String, String> getSamplePayloadData() {
        Map<String, String> pushData = new HashMap<>();
        pushData.put("messageId", "msgid");
        pushData.put("text", "txt");
        pushData.put("user", "kaguya chan");
        return pushData;
    }
}
