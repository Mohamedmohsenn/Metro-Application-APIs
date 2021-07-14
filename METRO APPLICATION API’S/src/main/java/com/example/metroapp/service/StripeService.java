package com.example.metroapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.metroapp.interfaces.IPaymentService;
<<<<<<< Updated upstream
=======
import com.example.metroapp.model.User;
import com.example.metroapp.payload.ChargeRequest;
import com.example.metroapp.payload.SignUpRequest;
import com.example.metroapp.repository.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
>>>>>>> Stashed changes
import com.stripe.exception.ApiConnectionException;
import com.stripe.exception.ApiException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.exception.StripeException;
<<<<<<< Updated upstream
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.CustomerCollection;
import com.stripe.model.ExpandableField;
=======
import com.stripe.model.*;
>>>>>>> Stashed changes
import com.stripe.net.StripeResponse;
import com.example.metroapp.properties.SpringBootStripeProperties;
import com.example.metroapp.model.StripeCharge;
import com.stripe.Stripe;
<<<<<<< Updated upstream
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> Stashed changes
import org.springframework.stereotype.Service;

@Service
public class StripeService implements IPaymentService
{
<<<<<<< Updated upstream

    public String addCharge(StripeCharge charge) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
        Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();
=======
    @Autowired
    UserRepo userRepo;
    public Boolean addCharge(ChargeRequest chargeRequest , String customerId, Integer userId) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
        Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();

        String cardID = addCard(chargeRequest,customerId);

>>>>>>> Stashed changes
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        Charge c = new Charge();
        StripeResponse response = null;
        try {
<<<<<<< Updated upstream
            chargeParams.put("amount", charge.getAmount() );
            chargeParams.put("currency", charge.getCurrency());
            chargeParams.put("description", charge.getDescription());
            chargeParams.put("customer", charge.getCustomerId());
            chargeParams.put("source", charge.getPaymentMethodId());
=======
            chargeParams.put("amount", (100*chargeRequest.getAmount()));
            chargeParams.put("currency", "usd");
            chargeParams.put("description", "Metro User Payment");
            chargeParams.put("customer", customerId);
            chargeParams.put("source", cardID);
>>>>>>> Stashed changes
            c = Charge.create(chargeParams);
            response = c.getLastResponse();
        } catch (StripeException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
<<<<<<< Updated upstream
        if (response != null)
            return response.body();
=======
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
>>>>>>> Stashed changes
        else return null;
    }


<<<<<<< Updated upstream
    public String retrieveCharge(String cid) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException {
        Stripe.apiKey = SpringBootStripeProperties.springBootStripeData.get("stripe.api.key").toString();
        // TODO Auto-generated method stub
        Charge c = new Charge();;
        StripeResponse response = null;
        try {
            c = Charge.retrieve(cid);
            response = c.getLastResponse();
        } catch (StripeException e) {
=======

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
>>>>>>> Stashed changes
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (response != null)
            return response.body();
        else return null;
<<<<<<< Updated upstream

    }
=======
    }

>>>>>>> Stashed changes
}
