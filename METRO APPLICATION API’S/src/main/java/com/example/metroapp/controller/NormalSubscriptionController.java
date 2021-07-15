package com.example.metroapp.controller;


import com.example.metroapp.interfaces.INormalSubscriptionService;
import com.example.metroapp.interfaces.ITicketService;
import com.example.metroapp.model.NormalSubscribtion;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class NormalSubscriptionController {

    @Autowired
    INormalSubscriptionService normalSubscriptionService;

    @PostMapping("/AddNormalSubscription")
    public ResponseEntity<HashMap<String, String>> AddSubscription(@RequestBody NormalSubscribtion normalSubscribtion)
    {
        HashMap<String, String> map= new HashMap<>();
        if(normalSubscribtion.getEmail() == null ||normalSubscribtion.getnational_id()==null)
        {   System.out.print(normalSubscribtion.getEmail()+normalSubscribtion.getfull_name()+normalSubscribtion.getnational_id());
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        else if(normalSubscriptionService.addSubscripe(normalSubscribtion))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/UpdateNormalSubscription")
    public ResponseEntity<HashMap<String, String>> UpdateSubscription(@RequestParam Integer user_id, @RequestParam Integer subscription_id)
    {
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

    @GetMapping("/UseSubscription")
    public ResponseEntity<?> UseSubscription( @RequestParam String source, @RequestParam String destination,@RequestBody User user)
    {

        HashMap<String, String> map= new HashMap<>();
        map.put("message","no value");
        if(user.getUser_id() == null || source== null ||destination==null)
        {
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        else if(normalSubscriptionService.useSubscription(user,source,destination))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
