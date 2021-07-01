package com.example.springdiplomapp.controller;

import com.example.springdiplomapp.dto.DataDTO;
import com.example.springdiplomapp.repository.DataDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class DataDTOController {
    @Autowired
    DataDTORepository dataDTORepository;

    @GetMapping("/giveDataDTO")
    public ResponseEntity<List<DataDTO>> getDataDTO(@RequestParam(required = false) String type) {
        try {
            List<DataDTO> dataDTOS = new ArrayList<>(dataDTORepository.findAllData());
            return new ResponseEntity<>(dataDTOS, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
