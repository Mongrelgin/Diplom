package com.example.springdiplomapp.controller;

import com.example.springdiplomapp.model.Data;
import com.example.springdiplomapp.repository.DataRepository;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Arrays;

@CrossOrigin(origins = "http://localhost:1883")
@RestController
@RequestMapping("/broker")
public class DataController {
    DataRepository dataRepository;

    @PostMapping("/addData")
    public void addNewData(@RequestBody MqttMessage mqttMessage) {
        Data data = new Data();
        data.setId_sensor((long) mqttMessage.getId());
        data.setData(Arrays.toString(mqttMessage.getPayload()));
        data.setDate_time(new Timestamp(System.currentTimeMillis()));
        data.setId_area(0L);
        dataRepository.save(data);
    }
}
