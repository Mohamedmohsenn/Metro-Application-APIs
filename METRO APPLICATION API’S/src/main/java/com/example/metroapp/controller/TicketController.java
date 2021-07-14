package com.example.metroapp.controller;


import com.example.metroapp.interfaces.ITicketService;
import com.example.metroapp.model.Ticket;
<<<<<<< Updated upstream
import com.example.metroapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
=======
import com.example.metroapp.security.jwt.JwtUtils;
import com.example.metroapp.security.services.UserDetailsImpl;
import com.example.metroapp.security.services.UserDetailsServiceImpl;
import com.example.metroapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
>>>>>>> Stashed changes
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class TicketController {

    @Autowired
    ITicketService ticketService;

<<<<<<< Updated upstream
    @GetMapping("/GetUserTickets")
    public ResponseEntity<?> getUserTickets(@RequestParam Integer userID)
    {
=======
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("api/GetUserTickets")
    public ResponseEntity<?> getUserTickets(@RequestHeader String Authorization)
    {
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(username);
        int userID=userDetails.getId();

>>>>>>> Stashed changes
        Map<String, Set<Ticket>> mp = new HashMap<>();
        mp.put("tickets_data",ticketService.getUserTickets(userID));
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }

<<<<<<< Updated upstream
    @GetMapping("/GetTicketPrice")
=======
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("api/GetTicketPrice")
>>>>>>> Stashed changes
    public ResponseEntity<?> getTicketPrice(@RequestParam String source,@RequestParam String destination)
    {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("ticket_price",ticketService.getTicketPrice(source,destination));
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }

<<<<<<< Updated upstream
    @GetMapping("/BuyTicket")
    public ResponseEntity<?> buyTicketUsingWalet(@RequestParam Integer userID, @RequestParam Integer price)
    {
        Map<String, String> map = new HashMap<>();
        Boolean response = ticketService.buyTicketUsingWallet(userID, price);
=======
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("api/BuyTicket")
    public ResponseEntity<?> buyTicket(@RequestHeader String Authorization, @RequestParam Integer price)
    {
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(username);
        int userID=userDetails.getId();

        Map<String, String> map = new HashMap<>();
        Boolean response = ticketService.buyTicket(userID, price);
>>>>>>> Stashed changes
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
