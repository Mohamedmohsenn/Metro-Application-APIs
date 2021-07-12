package com.example.metroapp.controller;


import com.example.metroapp.interfaces.ITicketService;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class TicketController {

    @Autowired
    ITicketService ticketService;

    @GetMapping("/GetUserTickets")
    public ResponseEntity<?> getUserTickets(@RequestParam Integer userID)
    {
        Map<String, Set<Ticket>> mp = new HashMap<>();
        mp.put("tickets_data",ticketService.getUserTickets(userID));
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }

    @GetMapping("/GetTicketPrice")
    public ResponseEntity<?> getTicketPrice(@RequestParam String source,@RequestParam String destination)
    {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("ticket_price",ticketService.getTicketPrice(source,destination));
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }

    @GetMapping("/BuyTicket")
    public ResponseEntity<?> buyTicketUsingWalet(@RequestParam Integer userID, @RequestParam Integer price)
    {
        Map<String, String> map = new HashMap<>();
        Boolean response = ticketService.buyTicketUsingWalet(userID, price);
        if(response)
        {
            map.put("message","success");
        }
        else
        {
            map.put("message","failed");
        }
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
