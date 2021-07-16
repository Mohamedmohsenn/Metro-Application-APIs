package com.example.metroapp.interfaces;

import com.example.metroapp.model.Subscribtion;

import java.util.List;

public interface ISubscriptionService {
   public Subscribtion getSubscription(int id);
   public boolean addSubscripe (Subscribtion User_data);
   public boolean updateSubscripe (int id,int price);
   public boolean deleteSubscripe (int id);
}
