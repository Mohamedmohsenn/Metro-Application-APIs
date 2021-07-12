package com.example.metroapp.interfaces;

import com.example.metroapp.model.StripeCharge;
import com.stripe.exception.*;

public interface IPaymentService {
    //public void init();
    public String addCharge(StripeCharge charge) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException;
    public String retrieveCharge(String cid) throws AuthenticationException, InvalidRequestException, ApiConnectionException, CardException, ApiException;
    }
