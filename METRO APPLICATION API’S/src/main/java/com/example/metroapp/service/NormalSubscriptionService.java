/*
package com.example.metroapp.service;

import com.example.metroapp.interfaces.INormalSubscriptionService;
import com.example.metroapp.interfaces.ISubscriptionService;
import com.example.metroapp.interfaces.ITripService;
import com.example.metroapp.model.*;
import com.example.metroapp.repository.NormalSubscriptionRepo;
import com.example.metroapp.repository.SubscriptionRepo;
import com.example.metroapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.sql.Date;
@Service
public class NormalSubscriptionService implements INormalSubscriptionService {
    @Autowired
    private NormalSubscriptionRepo normalSubscriptionRepo;

    @Autowired
    TripService tripService;


    @Autowired
    UserRepo userRepo;

    @Autowired
    SubscriptionRepo subscriptionRepo;

    @Override
    public boolean addSubscripe (NormalSubscribtion User_data)
    {
        List<NormalSubscribtion>NormalSubscribtions= normalSubscriptionRepo.findAll();
        User user=userRepo.findById(User_data.getUser().getUser_id()).get();
        Subscribtion subscribtion=subscriptionRepo.findById(User_data.getSubscription().getSubscription_id()).get();
        Map<String,Boolean> getTripPath = tripService.getTripPath(User_data.getSource(),User_data.getTarget());
        System.out.print(User_data.getSource()+" "+User_data.getTarget());
        for(NormalSubscribtion subscription : NormalSubscribtions)
        {
            if(subscription.getUser().getUser_id()==User_data.getUser().getUser_id())
            {
                return false;
            }
        }
        if(user.getBalance()>subscribtion.getPrice()&&subscribtion.getstation_num()>getTripPath.size()) {
            user.setBalance(user.getBalance()-subscribtion.getPrice());
            User_data.setStart_date(Date.valueOf(LocalDate.now()));
            User_data.setEnd_date(Date.valueOf(LocalDate.now().plusMonths(subscribtion.getmonths_num())));
            normalSubscriptionRepo.save(User_data);
            user.setNormalSubscribtion(User_data);
            userRepo.save(user);

            return  true;
        }
            return false;

    }
    @Override
    public boolean updateSubscripe (Integer user_id,Integer subscription_id)
    {
        List<NormalSubscribtion>NormalSubscribtions= normalSubscriptionRepo.findAll();
        User user=userRepo.findById(user_id).get();
        for(NormalSubscribtion subscription : NormalSubscribtions)
        {
            if(subscription.getUser().getUser_id()==user_id)
            {
                if(user.getBalance()>subscriptionRepo.findById(subscription_id).get().getPrice()) {
                    user.setBalance(user.getBalance()-subscriptionRepo.findById(subscription_id).get().getPrice());
                    user.getNormalSubscribtion().setSubscription(subscriptionRepo.findById(subscription_id).get());
                    user.getNormalSubscribtion().setTrips_num(0);
                    userRepo.save(user);
                    normalSubscriptionRepo.save(user.getNormalSubscribtion());
                    return  true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean useSubscription(User user , String source, String destination ) {
        NormalSubscribtion NormalSubscribtions = normalSubscriptionRepo.findByUser(user);
        Map<String,Boolean> getTripPath = tripService.getTripPath(source,destination);
        if(NormalSubscribtions!=null) {
            int trips = NormalSubscribtions.getSubscription().gettrips_num();
            Integer previous_trips=NormalSubscribtions.getTrips_num();
            if(previous_trips==null)
            {
                previous_trips=0;
            }
            int stations = NormalSubscribtions.getSubscription().getstation_num();
            Date startdate = (Date) NormalSubscribtions.getStart_date();
            Date enddate = (Date) NormalSubscribtions.getEnd_date();
            if(trips>previous_trips && getTripPath.size()<stations && startdate.before(enddate))
            {
                NormalSubscribtions.setTrips_num(previous_trips+1);
                normalSubscriptionRepo.save(NormalSubscribtions);
                return true;
            }
        }
        return false;
    }
}
*/