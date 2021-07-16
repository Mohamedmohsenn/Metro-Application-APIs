package com.example.metroapp.controller;
/*

import com.example.metroapp.interfaces.IStationService;
import com.example.metroapp.interfaces.ISubscriptionService;
import com.example.metroapp.model.NormalSubscribtion;
import com.example.metroapp.model.Station;
import com.example.metroapp.model.Subscribtion;
import com.example.metroapp.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class SubscriptionController {

    @Autowired
    ISubscriptionService subscriptionService;

    @GetMapping("/GetSubscription")
    public ResponseEntity<?> getSubscription(@RequestParam int id)
    {
        HashMap<String, Subscribtion> map = new HashMap<>();
        Subscribtion subscribtion = subscriptionService.getSubscription(id);
        map.put("subscription_data", subscribtion);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/AddSubscriptionn")
    public ResponseEntity<HashMap<String, String>> AddSubscription(@RequestBody Subscribtion subscribtion)
    {
        HashMap<String, String> map= new HashMap<>();
            map.put("message","failed");
        if(subscriptionService.addSubscripe(subscribtion))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @PostMapping("/UpdateSubscriptionn")
    public ResponseEntity<HashMap<String, String>> UpdateSubscription(@RequestParam int id,@RequestParam int price)
    {
        HashMap<String, String> map= new HashMap<>();
        map.put("message","failed");
        if(subscriptionService.updateSubscripe(id,price))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @DeleteMapping("/DeleteSubscriptionn")
    public ResponseEntity<HashMap<String, String>> DeleteSubscription(@RequestParam int id)
    {
        HashMap<String, String> map= new HashMap<>();
        map.put("message","failed");
        if(subscriptionService.deleteSubscripe(id))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
*/