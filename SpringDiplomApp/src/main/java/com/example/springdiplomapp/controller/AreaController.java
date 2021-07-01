package com.example.springdiplomapp.controller;

import com.example.springdiplomapp.model.Area;
import com.example.springdiplomapp.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AreaController {
    @Autowired
    AreaRepository areaRepository;

    /*
    @GetMapping("/zones")
    public ResponseEntity<List<Area>> getAllAreas(@RequestParam(required = false) String type)  {
        try {
            List<Area> areas = new ArrayList<>(areaRepository.findAll());
            if (areas.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            Map<String, List<Map<String, String>>>
            //return new ResponseEntity<>(areas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

     */

    @PostMapping("/zones")
    public ResponseEntity<Area> createArea(@RequestBody String name) {
        try {
            Area area = areaRepository.save(new Area(name));
            return new ResponseEntity<>(area, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/zones/{id}")
    public ResponseEntity<Area> updateArea(@PathVariable("id") long id, @RequestBody String string) {
        Optional<Area> optionalArea = areaRepository.findById(id);

        if (optionalArea.isPresent()) {
            Area _area = optionalArea.get();
            _area.setName(string);
            return new ResponseEntity<>(areaRepository.save(_area), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
