package com.example.springdiplomapp.controller;

import com.example.springdiplomapp.model.ControlType;
import com.example.springdiplomapp.repository.ControlTypeRepository;
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
public class ControlTypeController {
    @Autowired
    ControlTypeRepository controlTypeRepository;

    @GetMapping("/controltypes")
    public ResponseEntity<List<ControlType>> getAllControlTypes(@RequestParam(required = false) String type) {
        try {

            List<ControlType> controlTypes = new ArrayList<>(controlTypeRepository.findAll());

            if (controlTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(controlTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/controltypes/{id}")
    public ResponseEntity<ControlType> getControlTypeById(@PathVariable("id") long id) {
        Optional<ControlType> optionalControlType = controlTypeRepository.findById(id);

        return optionalControlType.map(controlType -> new ResponseEntity<>(controlType, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/controltypes")
    public ResponseEntity<ControlType> createControlType(@RequestBody ControlType controlType) {
        try {
            ControlType _controlType = controlTypeRepository.save(new ControlType(controlType.getName()));
            return new ResponseEntity<>(_controlType, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/controltypes/{id}")
    public ResponseEntity<ControlType> updateControlType(@PathVariable("id") long id, @RequestBody ControlType controlType) {
        Optional<ControlType> optionalControlType = controlTypeRepository.findById(id);

        if (optionalControlType.isPresent()) {
            ControlType _controlType = optionalControlType.get();
            _controlType.setName(controlType.getName());
            return new ResponseEntity<>(controlTypeRepository.save(_controlType), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
