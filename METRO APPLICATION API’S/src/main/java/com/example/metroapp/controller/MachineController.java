package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IMachineService;
import com.example.metroapp.payload.MachineRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@RestController
public class MachineController {

@Autowired
    IMachineService iMachineService;
    @Value("${metroapp.apiKey}")
    private String apiKey;

@PostMapping("/auth/Machine")
public ResponseEntity<HashMap<String, String>> Pass (@RequestHeader String ApiKey, @RequestBody MachineRequest machineRequest){
    HashMap<String, String> map = new HashMap<>();
    if (!ApiKey.equals(apiKey)){
        map.put("message","Error: UnAuthority third party !");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
}
    if (machineRequest.getType().equals("Ticket")){
        if(iMachineService.ValidateTicket(machineRequest.getUserID(),machineRequest.getReqID(),machineRequest.getStationID())){
            map.put("message","Ticket Validated Successfully..");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        else
        {
            map.put("message","Error: Ticket is not valid!");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }
    else if (machineRequest.getType().equals("Sub")){
        if(iMachineService.ValidateSub(machineRequest.getUserID(),machineRequest.getReqID(),machineRequest.getStationID()))
        {
            map.put("message","Subscription Validated Successfully..");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        else {
            map.put("message","Error: Subscription is not Valid !");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }
    else {
        map.put("message","Error: Request type is not declared !");
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
}
}
