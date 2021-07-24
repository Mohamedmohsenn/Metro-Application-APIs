package com.example.metroapp.controller;


import com.example.metroapp.interfaces.IStationService;

import com.example.metroapp.model.Station;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@RestController
public class StationController {

    @Autowired
    IStationService stationService;

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/GetAllStations")
    public Map<String,Map<String,Integer>> getAllStations()
    {
        Map<String,Map<String,Integer>> map = new HashMap<>();
        Map<String,Integer> mp = stationService.getAllStations();
        map.put("stations", mp);
        return map;
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/GetClosestStation")
    public ResponseEntity<?> getClosestStation(@RequestParam double latitude,@RequestParam double longitude) {
        Map<String, Station> map = new HashMap<>();
        map.put("stations",stationService.getClosestStation(latitude,longitude));
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
