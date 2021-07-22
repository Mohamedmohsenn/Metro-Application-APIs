
package com.example.metroapp.service;

import com.example.metroapp.interfaces.INormalSubscriptionService;
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

    @Autowired
    INormalSubscriptionService normalSubscriptionService;

    @Override
    public boolean addSubscripe (NormalSubscribtion User_data,int userID)
    {
        List<NormalSubscribtion>NormalSubscribtions= normalSubscriptionRepo.findAll();
        User user=userRepo.findById(userID).get();
        User_data.setSubscription_id(1);
        System.out.print(User_data.getSource()+User_data.getTarget()+User_data.getPeriod());
        Subscription subscription1 =  normalSubscriptionService.GetSubscriptionType(User_data.getSource(),User_data.getTarget(),User_data.getPeriod());
        User_data.setSubscription(subscription1);
        User_data.setTrips_num(subscription1.gettrips_num());
        Map<String,Boolean> getTripPath = tripService.getTripPath(User_data.getSource(),User_data.getTarget());
        System.out.print(User_data.getSource()+" "+User_data.getTarget());
        for(NormalSubscribtion subscription : NormalSubscribtions)
        {
            if(subscription.getUser().getUser_id()==userID)
            {
                return false;
            }
        }
        if(user.getBalance()>subscription1.getPrice()) {
            user.setBalance(user.getBalance()-subscription1.getPrice());
            User_data.setStart_date(Date.valueOf(LocalDate.now()));
            User_data.setEnd_date(Date.valueOf(LocalDate.now().plusMonths(subscription1.getmonths_num())));
            User_data.setUser(user);

            normalSubscriptionRepo.save(User_data);
            user.setNormalSubscribtion(User_data);
            userRepo.save(user);

            return  true;
        }
            return false;

    }

    @Override
    public boolean updateSubscripe (Integer user_id,String source,  String target, int period)
    {
        List<NormalSubscribtion>NormalSubscribtions= normalSubscriptionRepo.findAll();
        User user=userRepo.findById(user_id).get();
        Subscription subscription1 =  normalSubscriptionService.GetSubscriptionType(source,target,period);

        for(NormalSubscribtion subscription : NormalSubscribtions)
        {
            if(subscription.getUser().getUser_id()==user_id)
            {

                if(user.getBalance()> subscription1.getPrice()) {
                    user.setBalance(user.getBalance()- subscription1.getPrice());
                    user.getNormalSubscribtion().setSubscription(subscription1);
                    user.getNormalSubscribtion().setTrips_num(subscription1.gettrips_num());
                    user.getNormalSubscribtion().setStart_date(Date.valueOf(LocalDate.now()));
                    user.getNormalSubscribtion().setEnd_date(Date.valueOf(LocalDate.now().plusMonths(subscription1.getmonths_num())));
                    user.getNormalSubscribtion().setSource(source);
                    user.getNormalSubscribtion().setTarget(target);
                    user.getNormalSubscribtion().setPeriod(period);
                    userRepo.save(user);
                    normalSubscriptionRepo.save(user.getNormalSubscribtion());
                    return  true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean useSubscription(Integer user_id , String source, String destination ) {
        User user=userRepo.getById(user_id);
        NormalSubscribtion NormalSubscribtions = normalSubscriptionRepo.findByUser(user);
        Map<String,Boolean> getTripPath = tripService.getTripPath(source,destination);
        if(NormalSubscribtions!=null) {
            int trips = NormalSubscribtions.getSubscription().gettrips_num();
            Integer previous_trips=NormalSubscribtions.getTrips_num();
            if(previous_trips==null)
            {
                previous_trips=0;
            }
            //int stations = NormalSubscribtions.getSubscription().getstation_num();
            long startdate = NormalSubscribtions.getStart_date().getTime();
            long enddate = NormalSubscribtions.getEnd_date().getTime();
            if(trips>previous_trips  && startdate<enddate)
            {
                NormalSubscribtions.setTrips_num(previous_trips+1);
                normalSubscriptionRepo.save(NormalSubscribtions);
                return true;
            }
        }
        return false;
    }

    @Override
    public Subscription GetSubscriptionType(String source, String target, int period)
    {
        int regions =tripService.getNumberOfRegions(source,target);
        List<Subscription> subscriptions =subscriptionRepo.findAll();
        for(Subscription subscription : subscriptions)
        {
            if(subscription.getregion_num()==regions && subscription.getmonths_num()==period)
            {
                return subscription;
            }
        }
     return null;
    }

    @Override
    public Integer GetSubscriptionPrice(String source, String target, int period)
    {
        int regions =tripService.getNumberOfRegions(source,target);
        List<Subscription> subscriptions =subscriptionRepo.findAll();
        for(Subscription subscription : subscriptions)
        {
            if(subscription.getregion_num()==regions && subscription.getmonths_num()==period)
            {
                return  subscription.getPrice();
            }
        }
        return null;
    }

    @Override
    public NormalSubscribtion CheckSubscripe(int user_id) {
        User user=userRepo.findById(user_id).get();

        if(normalSubscriptionRepo.findByUser(user)!=null)
        {
            return user.getNormalSubscribtion() ;
        }
        return null;
    }
}
