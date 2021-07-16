package com.example.metroapp.interfaces;

import com.example.metroapp.model.NormalSubscribtion;
import com.example.metroapp.model.Station;
import com.example.metroapp.model.User;

public interface INormalSubscriptionService {
    boolean addSubscripe (NormalSubscribtion User_data,int userID);
    boolean updateSubscripe (Integer user_id,Integer subscription_id);
    boolean useSubscription(Integer user_id  , String source, String destination);

}
