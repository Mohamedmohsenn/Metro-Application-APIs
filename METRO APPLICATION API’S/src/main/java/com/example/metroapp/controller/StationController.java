package com.example.metroapp.controller;


import com.example.metroapp.interfaces.IBasicStationService;
import com.example.metroapp.interfaces.IStationService;
import com.example.metroapp.model.Line;
import com.example.metroapp.model.Station;
import com.example.metroapp.payload.request.UpdateStationRequest;
import com.example.metroapp.repository.LineRepo;
import com.example.metroapp.repository.StationRepo;
import com.example.metroapp.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StationController {

    @Autowired
    IStationService stationService;
    @Autowired
    LineRepo lineRepo;

    @Autowired
    IBasicStationService basicStationService;

    @Autowired
    private LineService lineService;


    @GetMapping("/GetAllStations")
    public ResponseEntity<?> getAllStations()
    {
        return new ResponseEntity<>(basicStationService.getAllStations(),HttpStatus.OK);
    }

    @RequestMapping("/addStation")
    public String getStations(Model model)
    {
        List<Station> stations = stationService.getAllStations();
        List<Line> lines = lineService.getAllLines();
        model.addAttribute("stations", stations);
        model.addAttribute("lines", lines);
        return "addStation";
    }

    @RequestMapping("/Station")
    public String goToStation(Model model)
    {
        List<Station> stations = stationService.getAllStations();
        List<Line> lines = lineService.getAllLines();
        model.addAttribute("stations", stations);
        model.addAttribute("lines", lines);
        return "station";
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
