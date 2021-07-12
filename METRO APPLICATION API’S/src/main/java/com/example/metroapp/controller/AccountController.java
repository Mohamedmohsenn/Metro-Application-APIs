package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IAccountService;
import com.example.metroapp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

@RestController
public class AccountController {
    @Autowired
    private IAccountService userService;

    @PostMapping("/SignUp")
    public ResponseEntity<HashMap<String, String>> signUp(@RequestBody User user)
    {
        HashMap<String, String> map = new HashMap<>();
        if(user.getEmail() == null || user.getPassword() == null || user.getUser_name() == null )
        {
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        else if(userService.SignUp(user))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);

        }
        else
        {
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }

    @PostMapping("/Login")
    public ResponseEntity<HashMap<String, String>> login(@RequestBody User user)
    {
        HashMap<String, String> map = new HashMap<>();
        if(user.getEmail() == null || user.getPassword() == null)
        {
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
        }
        else if(userService.login(user.getEmail(),user.getPassword()))
        {
            map.put("message","success");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        else
        {
            map.put("message","failed");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
    }
}
