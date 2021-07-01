package com.example.springdiplomapp.controller;

import com.example.springdiplomapp.model.Control;
import com.example.springdiplomapp.repository.ControlRepository;
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
public class ControlController {
    @Autowired
    ControlRepository controlRepository;

    @GetMapping("/controls")
    public ResponseEntity<List<Control>> getAllControls(@RequestParam(required = false) String text) {
        try {
            List<Control> controls = new ArrayList<>(controlRepository.findAll());

            if (controls.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(controls, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/controls")
    public ResponseEntity<Control> createControl(@RequestBody String ip, @RequestBody String id_type, @RequestBody String settings) {
        try {
            Control control = new Control(ip, Long.parseLong(id_type), Integer.parseInt(settings), false);
            return new ResponseEntity<>(controlRepository.save(control), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/controls/{id}")
    public ResponseEntity<Control> activateControl(@PathVariable("id") long id) {
        Optional<Control> optionalControl = controlRepository.findById(id);

        if (optionalControl.isPresent()) {
            Control control = optionalControl.get();
            control.setEnabled(!control.getEnabled());
            return new ResponseEntity<>(controlRepository.save(control), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/controls/{id}")
    public ResponseEntity<Control> updateControl(@PathVariable("id") long id, @RequestBody String ip, @RequestBody String settings) {
        Optional<Control> optionalControl = controlRepository.findById(id);

        if (optionalControl.isPresent()) {
            Control control = optionalControl.get();
            control.setIp(ip);
            control.setSettings(Integer.parseInt(settings));
            return new ResponseEntity<>(controlRepository.save(control), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
