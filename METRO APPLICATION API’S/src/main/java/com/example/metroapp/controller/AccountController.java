package com.example.metroapp.controller;

import com.example.metroapp.interfaces.IAccountService;
import com.example.metroapp.interfaces.IPaymentService;
import com.example.metroapp.model.User;

import com.example.metroapp.payload.LoginRequest;
import com.example.metroapp.payload.SignUpRequest;
import com.example.metroapp.repository.UserRepo;
import com.example.metroapp.security.jwt.JwtUtils;
import com.example.metroapp.security.services.UserDetailsImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stripe.exception.*;
import com.stripe.net.StripeResponse;
import org.dom4j.tree.BackedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.HashMap;

@CrossOrigin
@RestController
public class AccountController {
    @Autowired
    private IAccountService userService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepo userRepository;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    IPaymentService stripeService;

    @PostMapping("auth/SignUp")
    public ResponseEntity<HashMap<String, String>> signUp(@Valid @RequestBody SignUpRequest signUpRequest)
    {
        HashMap<String, String> map = new HashMap<>();
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {

            map.put("message","Error: Username is already taken!");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            map.put("message","Error: Email is already in use!");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        //Create Stripe test Customer
        String customerID=null;
        try {
            customerID= stripeService.addCustomer(signUpRequest);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            e.printStackTrace();
        } catch (ApiConnectionException e) {
            e.printStackTrace();
        } catch (CardException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        // Create new user's account
        User user = new User(
                signUpRequest.getUsername(),
                signUpRequest.getFullname(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getPhone_number(),
                signUpRequest.getDate_of_birth(),
                0.0,
                "user",
                customerID
                );
        userRepository.save(user);

        map.put("message","User Registered Successfully");
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("auth/Login")
    public ResponseEntity<HashMap<String, String>> login(@Valid @RequestBody LoginRequest loginRequest)
    {
        HashMap<String, String> map = new HashMap<>();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            map.put("message","Success");
            map.put("Authorization",jwt);
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        catch (BadCredentialsException e){
            map.put("message","failed");
            map.put("Authorization",null);
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
    }
}
