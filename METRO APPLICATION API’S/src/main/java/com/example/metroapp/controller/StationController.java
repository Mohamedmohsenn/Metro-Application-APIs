package com.example.metroapp.controller;


import com.example.metroapp.interfaces.IStationService;
import com.example.metroapp.model.Station;
import com.example.metroapp.repository.LineRepo;
import com.example.metroapp.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class StationController {

    @Autowired
    IStationService stationService;

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/GetAllStations")
    public ResponseEntity<?> getAllStations()
    {
        return new ResponseEntity<>(stationService.getAllStations(),HttpStatus.OK);
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/GetClosestStation")
    public ResponseEntity<?> getClosestStation(@RequestParam double latitude,@RequestParam double longitude) {
        return new ResponseEntity<>(stationService.getClosestStation(latitude,longitude),HttpStatus.OK);
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/GetLineStations")
    public ResponseEntity<?> getCertainLineStations(@RequestParam Integer id)
    {
        return new ResponseEntity<>(stationService.getCertainLineStations(id),HttpStatus.OK);
    }
}
