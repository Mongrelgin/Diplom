package com.example.springdiplomapp.service;

import com.example.springdiplomapp.config.SimpleMqttCallBack;
import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {
    @Autowired
    private IMqttClient mqttClient;

    public void publish(final String topic, final String payload, int qos, boolean retained)
            throws MqttPersistenceException, MqttException {
        MqttMessage mqttMessage = new MqttMessage();
        mqttMessage.setPayload(payload.getBytes());
        mqttMessage.setQos(qos);
        mqttMessage.setRetained(retained);

        mqttClient.publish(topic, mqttMessage);
        mqttClient.disconnect();
    }

    public void subscribe(final String topic) throws MqttException, InterruptedException {
        System.out.println("Message received:");

        mqttClient.subscribeWithResponse(topic, (tpic, msg) -> {
            System.out.println(msg.getId() + " -> " + new String(msg.getPayload()));
        });
    }

    public void subForBrokerElement() {
        try {
            MqttClient client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
            client.setCallback( new SimpleMqttCallBack() );
            client.connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}
