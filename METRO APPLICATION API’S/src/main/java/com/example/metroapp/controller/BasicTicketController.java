package com.example.metroapp.controller;


import com.example.metroapp.interfaces.IBasicTicketService;
import com.example.metroapp.model.BasicTicket;
import com.example.metroapp.model.Line;
import com.example.metroapp.repository.BasicTicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BasicTicketController {
    @Autowired
    IBasicTicketService basicTicketService;

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("GetBasicTickets")
    public ResponseEntity<?> getAllBasicTickets(@RequestHeader String Authorization)
    {
        Map<String, List<BasicTicket>> map = new HashMap<>();
        map.put("Basic Tickets:",basicTicketService.getAllBasicTickets());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
