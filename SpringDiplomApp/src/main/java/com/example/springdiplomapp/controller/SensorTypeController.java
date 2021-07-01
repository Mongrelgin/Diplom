package com.example.springdiplomapp.controller;

import com.example.springdiplomapp.model.*;
import com.example.springdiplomapp.repository.SensorTypeRepository;
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
public class SensorTypeController {
    @Autowired
    SensorTypeRepository sensorTypeRepository;

    @GetMapping("/sensortypes")
    public ResponseEntity<List<SensorType>> getAllSensorTypes(@RequestParam(required = false) String type) {
        try {
            List<SensorType> sensorTypes = new ArrayList<SensorType>();

            sensorTypeRepository.findAll().forEach(sensorTypes::add);

            if (sensorTypes.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(sensorTypes,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/sensortypes/{id}")
    public ResponseEntity<SensorType> getSensorTypeById(@PathVariable("id") long id) {
        Optional<SensorType> optionalSensorType = sensorTypeRepository.findById(id);

        if (optionalSensorType.isPresent()) {
            return new ResponseEntity<>(optionalSensorType.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/sensortypes")
    public ResponseEntity<SensorType> createSensorType(@RequestBody SensorType sensorType) {
        try {
            SensorType _sensorType = sensorTypeRepository.save(new SensorType(sensorType.getName()));
            return new ResponseEntity<>(_sensorType, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/sensortypes/{id}")
    public ResponseEntity<SensorType> updateSensorType(@PathVariable("id") long id, @RequestBody SensorType sensorType) {
        Optional<SensorType> optionalSensorType = sensorTypeRepository.findById(id);

        if (optionalSensorType.isPresent()) {
            SensorType _sensorType = optionalSensorType.get();
            _sensorType.setName(sensorType.getName());
            return new ResponseEntity<>(sensorTypeRepository.save(_sensorType), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
