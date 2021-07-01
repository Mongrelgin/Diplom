package com.example.springdiplomapp.controller;

import com.example.springdiplomapp.model.Sensor;
import com.example.springdiplomapp.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class SensorController {
    @Autowired
    SensorRepository sensorRepository;

    @GetMapping("/sensors")
    public ResponseEntity<List<Sensor>> getAllSensors(@RequestParam(required = false) String text) {
        try {
            List<Sensor> sensors = new ArrayList<>(sensorRepository.findAll());

            if (sensors.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(sensors, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/sensors/{id}")
    public ResponseEntity<Sensor> updateSensor(@PathVariable("id") long id, @RequestBody Sensor sensor) {
        Optional<Sensor> optionalSensor = sensorRepository.findById(id);

        if (optionalSensor.isPresent()) {
            Sensor _sensor = optionalSensor.get();
            _sensor.setIp(sensor.getIp());
            _sensor.setId_type(sensor.getId_type());
            _sensor.setEnabled(sensor.getEnabled());
            return new ResponseEntity<>(sensorRepository.save(_sensor), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
