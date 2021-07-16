package com.example.metroapp.service;
/*
import com.example.metroapp.interfaces.ISubscriptionService;
//import com.example.metroapp.model.NormalSubscribtion;
import com.example.metroapp.model.Subscribtion;
import com.example.metroapp.repository.SubscriptionRepo;
import com.example.metroapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService implements ISubscriptionService {
    @Autowired
    SubscriptionRepo subscriptionRepo;

    @Override
    public Subscribtion getSubscription(int id)
    {
        List<Subscribtion>Subscriptions=subscriptionRepo.findAll();
        for(Subscribtion subscription : Subscriptions)
        {
            if(subscription.getSubscription_id()==id)
            {
                return subscription;
            }
        }
        return null;
    }

    @Override
    public boolean addSubscripe (Subscribtion User_data)
    {
        List<Subscribtion>Subscribtions= subscriptionRepo.findAll();
        for(Subscribtion subscription : Subscribtions)
        {
            if(subscription.getSubscription_id()==User_data.getSubscription_id())
            {
                return false;
            }
        }
        subscriptionRepo.save(User_data);

        return false;
    }

    @Override
    public boolean updateSubscripe(int id,int price) {
         Subscribtion subscribtion= subscriptionRepo.findById(id).get();
        if(subscribtion==null)
        {
            return false;
        }
        subscribtion.setPrice(price);
        subscriptionRepo.save(subscribtion);
        return true;
    }

    @Override
    public boolean deleteSubscripe(int id) {
        subscriptionRepo.deleteById(id);
        return false;
    }
}
*/