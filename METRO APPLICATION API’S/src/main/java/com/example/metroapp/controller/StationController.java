package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IStationService;
import com.example.metroapp.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

@RestController
public class StationController {

    @Autowired
    IStationService stationService;

    @GetMapping("/GetNearstStation")
    public ResponseEntity<?> getNearStation(@RequestParam Double latitude, @RequestParam Double longitude)
    {
        HashMap<String, Station> map = new HashMap<>();
        Station station = stationService.getClosestStation(latitude, longitude);
        map.put("station_data", station);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
