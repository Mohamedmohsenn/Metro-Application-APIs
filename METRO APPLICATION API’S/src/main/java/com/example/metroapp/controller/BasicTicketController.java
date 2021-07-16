package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IBasicTicketService;
import com.example.metroapp.model.BasicTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BasicTicketController
{
    @Autowired
    private IBasicTicketService basicTicketService;

    @PostMapping("/AddBasicTicket")
    public ResponseEntity<?> addBasicTicket(@RequestBody BasicTicket basicTicket)
    {
        HashMap<String, String> map = new HashMap<>();
        if(basicTicketService.addBasicTicket(basicTicket))
        {
            map.put("message","success");
        }
        else
        {
            map.put("message","failed");
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/UpdateBasicTicket")
    public ResponseEntity<?> updateBasicTicket(@RequestBody BasicTicket basicTicket)
    {
        HashMap<String, String> map = new HashMap<>();
        if(basicTicketService.updateBasicTicket(basicTicket))
        {
            map.put("massage", "success");
        }
        else
        {
            map.put("massage", "failed");
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/DeleteBasicTicket")
    public ResponseEntity<?>  deleteBasicTicket(@RequestBody BasicTicket basicTicket)
    {
        HashMap<String, String> map = new HashMap<>();
        if(basicTicketService.deleteBasicTicket(basicTicket))
        {
            map.put("message","success");
        }
        else
        {
            map.put("message","failed");
        }
        return new ResponseEntity<>(map, HttpStatus.OK);

    }
    @PostMapping("/SelectAllBasicTicket")
    public ResponseEntity<?>  selectAllBasicTicket()
    {
        Map<String,List<BasicTicket>> map = new HashMap<>();
        List<BasicTicket> basicTickets = basicTicketService.selectAllBasicTicket();
        map.put("Basic_Tickets", basicTickets);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
