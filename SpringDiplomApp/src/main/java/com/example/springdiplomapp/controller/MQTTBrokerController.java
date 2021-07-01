package com.example.springdiplomapp.controller;

import com.example.springdiplomapp.service.MessagingService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class MQTTBrokerController {
    @Autowired
    private MessagingService messagingService;

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMqttMessage(@RequestBody String text) {
        final String topic = "greenhouse/topic/message";
        try {
            messagingService.subscribe(topic);
            messagingService.publish(topic, text, 0, true);
        } catch (MqttException | InterruptedException e) {
            e.printStackTrace();
        }
        messagingService.subForBrokerElement();
        return new ResponseEntity<>(null, HttpStatus.OK);

    }
}
