package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IBasicStationService;
import com.example.metroapp.interfaces.IStationService;
import com.example.metroapp.model.Station;
import com.example.metroapp.payload.request.EndStationRequest;
import com.example.metroapp.payload.request.MiddleStationRequest;
import com.example.metroapp.payload.request.StartStationRequest;
import com.example.metroapp.payload.request.UpdateStationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StationController {

    @Autowired
    IStationService stationService;

    @Autowired
    IBasicStationService basicStationService;

    @GetMapping("/GetNearstStation")
    public ResponseEntity<?> getNearStation(@RequestParam Double latitude, @RequestParam Double longitude)
    {
        HashMap<String, Station> map = new HashMap<>();
        Station station = stationService.getClosestStation(latitude, longitude);
        map.put("station_data", station);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/AddMiddleStation")
    public ResponseEntity<?> addStation(@RequestBody MiddleStationRequest stationRequest)
    {
        Map<String, String> map = new HashMap<>();
        if(basicStationService.addStation(stationRequest.getPrevStation(),stationRequest.getStation(),stationRequest.getAfterStation()))
            map.put("message", "success");
        else
            map.put("message", "failed");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/AddEndStation")
    public ResponseEntity<?> addStation(@RequestBody EndStationRequest stationRequest)
    {
        Map<String, String> map = new HashMap<>();
        if(basicStationService.addStation(stationRequest.getPrevStation(),stationRequest.getStation()))
            map.put("message", "success");
        else
            map.put("message", "failed");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/AddStartStation")
    public ResponseEntity<?> addStation(@RequestBody StartStationRequest stationRequest)
    {
        Map<String, String> map = new HashMap<>();
        if(basicStationService.addStation(stationRequest.getStation(),stationRequest.getAfterStation()))
            map.put("message", "success");
        else
            map.put("message", "failed");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/GetAllStations")
    public ResponseEntity<?> getAllStations()
    {
        return new ResponseEntity<>(basicStationService.getAllStations(),HttpStatus.OK);
    }

    @PostMapping("/UpdateStation")
    public ResponseEntity<?> updateStation(@RequestBody UpdateStationRequest updateStationRequest)
    {
        Map<String, String> map = new HashMap<>();
        if(basicStationService.updateStation(updateStationRequest.getId(),updateStationRequest.getStation()))
            map.put("message", "success");
        else
            map.put("message", "failed");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
