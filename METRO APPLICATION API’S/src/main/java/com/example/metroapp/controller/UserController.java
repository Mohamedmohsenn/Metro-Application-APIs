package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IUserService;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.security.jwt.JwtUtils;
import com.example.metroapp.security.services.UserDetailsImpl;
import com.example.metroapp.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@RestController
public class UserController {
    @Autowired
    IUserService userService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    @GetMapping("/GetUserBalance")
    public ResponseEntity<?> getUserBalance(@RequestHeader String Authorization){

        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(username);
        int userID=userDetails.getId();
        double balance= userService.getUserBalance(userID);
        Map<String, Double> mp = new HashMap<>();
        mp.put("userBalance",balance);
        return new ResponseEntity<>(mp, HttpStatus.OK);
    }
}
