package com.example.metroapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.metroapp.interfaces.IPaymentService;
import com.example.metroapp.model.User;
import com.example.metroapp.payload.ChargeRequest;
import com.example.metroapp.payload.SignUpRequest;
import com.example.metroapp.repository.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
import com.stripe.model.*;
import com.stripe.net.StripeResponse;
import com.example.metroapp.properties.SpringBootStripeProperties;
import com.example.metroapp.model.StripeCharge;
import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StripeService implements IPaymentService
{
    @Autowired
    UserRepo userRepo;
    public Boolean addCharge(ChargeRequest chargeRequest , String customerId, Integer userId) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
        Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();

        String cardID = addCard(chargeRequest,customerId);

        Map<String, Object> chargeParams = new HashMap<String, Object>();
        Charge c = new Charge();
        StripeResponse response = null;
        try {
            chargeParams.put("amount", (100*chargeRequest.getAmount()));
            chargeParams.put("currency", "usd");
            chargeParams.put("description", "Metro User Payment");
            chargeParams.put("customer", customerId);
            chargeParams.put("source", cardID);
            c = Charge.create(chargeParams);
            response = c.getLastResponse();
        } catch (StripeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (response != null){
            User user = userRepo.getById(userId);
            double newBalance= user.getBalance()+chargeRequest.getAmount();
            user.setBalance(newBalance);
            userRepo.save(user);
            return true;
        }
        else return false;
    }

    public String addCard(ChargeRequest chargeRequest, String custpmerId) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
        Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();

        Map<String, Object> retrieveParams = new HashMap<String, Object>();
        List<String> expandList = new ArrayList<>();

        Map<String, Object> params = new HashMap<String, Object>();
        Card card = new Card();
        StripeResponse response = null;

        String cardID=null;

        try {
            expandList.add("sources");
            retrieveParams.put("expand", expandList);
            Customer customer = Customer.retrieve(custpmerId, retrieveParams, null);

            Map<String, Object> cardParams = new HashMap<String, Object>();

            cardParams.put("number", chargeRequest.getCardnum());
            cardParams.put("exp_month", chargeRequest.getExp_month());
            cardParams.put("exp_year", chargeRequest.getExp_year());
            cardParams.put("cvc", chargeRequest.getCvv());

            Map<String, Object> tokenParams = new HashMap<String, Object>();
            tokenParams.put("card", cardParams);
            Token cardToken = Token.create(tokenParams);

            cardID=cardToken.getCard().getId();

            params.put("source", cardToken.getId());
            card = (Card) customer.getSources().create(params);
            response = card.getLastResponse();

        } catch (StripeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (response != null)
            return cardID;
        else return null;
    }



    public String addCustomer(SignUpRequest signUpRequest) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException, JsonProcessingException {
        Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();

        Map<String, Object> customerParams = new HashMap<String, Object>();

        Customer customer = new Customer();

        StripeResponse response = null;
        try {
            customerParams.put("description", "Metro User");
            customerParams.put("name", signUpRequest.getUsername());
            customerParams.put("email", signUpRequest.getEmail());
            //customerParams.put("address", cus.getAddress());

            customer = Customer.create(customerParams);
            return customer.getId();
        }
        catch (StripeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (response != null)
            return response.body();
        else return null;
    }

}
