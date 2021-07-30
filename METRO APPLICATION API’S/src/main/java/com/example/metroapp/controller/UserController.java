package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IUserService;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.model.User;
import com.example.metroapp.payload.ChangeWithPasswordRequest;
import com.example.metroapp.payload.DateRequest;
import com.example.metroapp.payload.LoginRequest;
import com.example.metroapp.repository.UserRepo;
import com.example.metroapp.security.jwt.JwtUtils;
import com.example.metroapp.security.services.UserDetailsImpl;
import com.example.metroapp.security.services.UserDetailsServiceImpl;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@CrossOrigin
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
    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @PostMapping("/ChangeUserPassword")
    public ResponseEntity<?> changeUserPassword(@RequestHeader String Authorization, @RequestParam String password, @RequestParam String Atrr ){
        Map<String, String> mp = new HashMap<>();
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        if(userService.changeUserPassword(username,password,Atrr)){
            mp.put("message","User Password updated successfully");
            return new ResponseEntity<>(mp, HttpStatus.OK);
        }
        mp.put("message","Old password is wrong , try again");
        return new ResponseEntity<>(mp, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @PostMapping("/ChangeUserEmail")
    public ResponseEntity<?> changeUserEmail(@RequestHeader String Authorization,  @RequestParam String password, @RequestParam String Atrr){
        Map<String, String> mp = new HashMap<>();
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        if(userService.changeUserEmail(username,password,Atrr)){
            mp.put("message","User Email updated successfully");
            return new ResponseEntity<>(mp, HttpStatus.OK);
        }
        mp.put("message","User password is wrong , try again");
        return new ResponseEntity<>(mp, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @PostMapping("/ChangeUserPhoneNum")
    public ResponseEntity<?> changeUserPhoneNum(@RequestHeader String Authorization, @RequestParam String password, @RequestParam String Atrr){
        Map<String, String> mp = new HashMap<>();
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        if(userService.changeUserPhoneNum(username,password,Atrr)){
            mp.put("message","User Phone Number updated successfully");
            return new ResponseEntity<>(mp, HttpStatus.OK);
        }
        mp.put("message","Password is wrong , try again");
        return new ResponseEntity<>(mp, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @PostMapping("/ChangeUserName")
    public ResponseEntity<?> changeUserName(@RequestHeader String Authorization, @RequestParam String newName){
        Map<String, String> mp = new HashMap<>();
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        if(userService.changeUserFullName(username,newName)){
            mp.put("message","User Name updated successfully");
            return new ResponseEntity<>(mp, HttpStatus.OK);
        }
        mp.put("message","Faild");
        return new ResponseEntity<>(mp, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin
    @PreAuthorize("hasAnyRole('user')")
    @PostMapping("/ChangeUserBirthDate")
    public ResponseEntity<?> changeUserBirthDate(@RequestHeader String Authorization,@Valid @RequestBody DateRequest dateRequest){
        Map<String, String> mp = new HashMap<>();
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        System.out.print(dateRequest.getNewDate());
        if(userService.changeUserDate(username,dateRequest.getNewDate())){
            mp.put("message","User Birth Date updated successfully");
            return new ResponseEntity<>(mp, HttpStatus.OK);
        }
        mp.put("message","Faild");
        return new ResponseEntity<>(mp, HttpStatus.BAD_REQUEST);
    }
}
