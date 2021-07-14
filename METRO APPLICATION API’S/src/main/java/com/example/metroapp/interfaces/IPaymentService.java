package com.example.metroapp.interfaces;

import com.example.metroapp.model.StripeCharge;
import com.example.metroapp.payload.ChargeRequest;
import com.example.metroapp.payload.SignUpRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.stripe.exception.*;

public interface IPaymentService {
    //public void init();
    public Boolean addCharge(ChargeRequest chargeRequest , String customerId, Integer userId) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException;
    public String addCustomer(SignUpRequest signUpRequest) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException, JsonProcessingException;
}
