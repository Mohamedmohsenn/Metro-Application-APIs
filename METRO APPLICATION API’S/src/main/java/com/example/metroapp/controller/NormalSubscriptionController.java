
package com.example.metroapp.controller;


import com.example.metroapp.interfaces.INormalSubscriptionService;
import com.example.metroapp.interfaces.ITicketService;
import com.example.metroapp.model.NormalSubscribtion;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.model.User;
import com.example.metroapp.security.jwt.JwtUtils;
import com.example.metroapp.security.services.UserDetailsImpl;
import com.example.metroapp.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class NormalSubscriptionController {

    @Autowired
    INormalSubscriptionService normalSubscriptionService;

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PreAuthorize("hasAnyRole('user')")
    @PostMapping("api/AddNormalSubscription")
    public ResponseEntity<HashMap<String, String>> AddSubscription(@RequestBody NormalSubscribtion normalSubscribtion,@RequestHeader String Authorization)
    {
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(username);
        int userID=userDetails.getId();

        HashMap<String, String> map= new HashMap<>();
        if(normalSubscribtion.getEmail() == null ||normalSubscribtion.getnational_id()==null)
        {   System.out.print(normalSubscribtion.getEmail()+normalSubscribtion.getfull_name()+normalSubscribtion.getnational_id());
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        else if(normalSubscriptionService.addSubscripe(normalSubscribtion,userID))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('user')")
    @PostMapping("api/UpdateNormalSubscription")
    public ResponseEntity<HashMap<String, String>> UpdateSubscription(@RequestHeader String Authorization, @RequestParam Integer subscription_id)
    {
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(username);
        Integer user_id=userDetails.getId();

        HashMap<String, String> map= new HashMap<>();
        if(user_id == null ||subscription_id==null)
        {   System.out.print(user_id+subscription_id);
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        else if(normalSubscriptionService.updateSubscripe(user_id,subscription_id))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("api/UseSubscription")
    public ResponseEntity<?> UseSubscription( @RequestParam String source, @RequestParam String destination,@RequestHeader String Authorization)
    {
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(username);
        Integer user_id=userDetails.getId();

        HashMap<String, String> map= new HashMap<>();
        map.put("message","no value");
        if(user_id == null || source== null ||destination==null)
        {
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        else if(normalSubscriptionService.useSubscription(user_id,source,destination))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
