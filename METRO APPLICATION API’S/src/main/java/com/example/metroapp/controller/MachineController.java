package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
public class MachineController {
@Autowired
    IMachineService iMachineService;

@GetMapping("/auth/Machine")
public ResponseEntity<HashMap<String, String>> Pass (){

}
}
