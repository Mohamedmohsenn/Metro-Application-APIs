
package com.example.metroapp.controller;

import java.util.HashMap;
import java.util.List;

import com.example.metroapp.interfaces.IPaymentService;
import com.example.metroapp.payload.ChargeRequest;
import com.example.metroapp.repository.UserRepo;
import com.example.metroapp.security.jwt.JwtUtils;
import com.example.metroapp.security.services.UserDetailsImpl;
import com.example.metroapp.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.example.metroapp.model.StripeCharge;
import com.example.metroapp.service.StationService;

import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

@RestController
public class ChargeController {
    @Autowired
    private IPaymentService chargeService;


    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @PreAuthorize("hasAnyRole('user')")
    @PostMapping(value="/api/v1/charges")
    public ResponseEntity<HashMap<String, String>> createCharge(@RequestBody ChargeRequest chargeRequest, @RequestHeader String Authorization) throws AuthenticationException, InvalidRequestException, CardException, ApiConnectionException, ApiException {
        HashMap<String, String> map = new HashMap<>();
        String Header[] = Authorization.split(" ");
        String username = jwtUtils.getUserNameFromJwtToken(Header[1]);
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(username);
        String customerID=userDetails.getStripe_id();
        int userID=userDetails.getId();

        if(chargeService.addCharge(chargeRequest,customerID,userID)){
            map.put("message","Balance Charged Successfully");
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        else
        {
            map.put("message","Error: Error with Payment method");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }
}
