package com.example.metroapp.controller;


import com.example.metroapp.interfaces.ILineService;
import com.example.metroapp.model.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LineController {

    @Autowired
    ILineService lineService;

    @GetMapping("/GetAllLines")
    public ResponseEntity<?> getAllLines()
    {
        Map<String,List<Line>> map = new HashMap<>();
        map.put("All lines :",lineService.getAllLines());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
