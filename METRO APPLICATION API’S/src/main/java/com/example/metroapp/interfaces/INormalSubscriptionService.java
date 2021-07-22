package com.example.metroapp.interfaces;

import com.example.metroapp.model.NormalSubscribtion;
import com.example.metroapp.model.Subscription;

public interface INormalSubscriptionService {
    boolean addSubscripe (NormalSubscribtion User_data,int userID);
    Subscription GetSubscriptionType (String source, String target, int period );
    boolean updateSubscripe (Integer user_id,  String source,  String target, int period);
    boolean useSubscription(Integer user_id  , String source, String destination);
    public Integer GetSubscriptionPrice(String source, String target, int period);
    public NormalSubscribtion CheckSubscripe (int user_id);

}
