package com.example.metroapp.interfaces;

import com.example.metroapp.model.StripeCharge;
<<<<<<< Updated upstream
=======
import com.example.metroapp.payload.ChargeRequest;
import com.example.metroapp.payload.SignUpRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
>>>>>>> Stashed changes
import com.stripe.exception.*;

public interface IPaymentService {
    //public void init();
<<<<<<< Updated upstream
    public String addCharge(StripeCharge charge) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException;
    public String retrieveCharge(String cid) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException;
    }
=======
    public Boolean addCharge(ChargeRequest chargeRequest , String customerId, Integer userId) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException;
    public String addCustomer(SignUpRequest signUpRequest) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException, JsonProcessingException;
}
>>>>>>> Stashed changes
