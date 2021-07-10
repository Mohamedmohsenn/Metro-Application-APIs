package com.example.metroapp.controller;

import com.example.metroapp.interfaces.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TripController {

    @Autowired
    ITripService tripService;

    @GetMapping("/GetPath")
    public ResponseEntity<?> getTripPath(@RequestParam String source,@RequestParam String destination)
    {
        Map<String, Map<String,Boolean>> map = new HashMap<>();
        map.put("path",tripService.getTripPath(source,destination));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/GetTime")
    public ResponseEntity<?> getTripEstimatedTime(@RequestParam String source,@RequestParam String destination)
    {
        Map<String,Integer> map = new HashMap<>();
        map.put("Time",tripService.getTripEstimatedTime(source,destination));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
