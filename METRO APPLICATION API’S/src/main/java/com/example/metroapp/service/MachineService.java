package com.example.metroapp.service;

import com.example.metroapp.interfaces.IMachineService;
import com.example.metroapp.interfaces.ITripService;
import com.example.metroapp.model.NormalSubscribtion;
import com.example.metroapp.model.Station;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.model.User;
import com.example.metroapp.repository.*;
import org.hibernate.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

@Service
public class MachineService implements IMachineService {
    @Autowired
    StationRepo stationRepo;
    @Autowired
    TicketRepo ticketRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    NormalSubscriptionRepo normalSubscriptionRepo;
    @Autowired
    ITripService iTripService;
    public Boolean ValidateTicket(int ticketID,String stationName){
        Ticket ticket;
        try {
            ticket=ticketRepo.findById(ticketID).orElse(null);
        }
        catch (Exception e){
            return false;
        }
        if(ticket==null)
            return false;
        if(ticket.getSource_station()==null){ //First machine checking
            ticket.setSource_station(stationName);
            ticketRepo.save(ticket);
            return true;
        }
        else {// Second machine checking
            String ticketSource= ticket.getSource_station();
            Map<String,Boolean> path= iTripService.getTripPath(ticketSource,stationName);
            int pathlength=path.size();
            if (pathlength>ticket.getMaximumTrips()){
                return false;
            }
            else {
                ticketRepo.delete(ticket); // ticket checked successfully
                return true;
            }
        }
    }
    public Boolean ValidateSub(int SubID,String stationName){
        Date currentDate= java.sql.Date.valueOf(LocalDate.now());
        NormalSubscribtion normalSubscribtion;
        try {
            normalSubscribtion = normalSubscriptionRepo.findById(SubID).orElse(null);
        }
            catch (Exception e)
            {
                return false;
            }
        if (normalSubscribtion==null)
            return false;
        Map<String,Boolean> path= iTripService.getTripPath(normalSubscribtion.getSource(),normalSubscribtion.getTarget());
        if(normalSubscribtion.getTrips_num()==0) //no trips to use
            return false;
        if (!normalSubscribtion.getEnd_date().after(currentDate)) //sub is expired
            return false;
        if(!path.containsKey(stationName))//station out of sub bounds
            return false;
        if(!normalSubscribtion.getIn_use()){//first_use
            normalSubscribtion.setIn_use(true);
            normalSubscriptionRepo.save(normalSubscribtion);
            return true;
        }
        else {
            int trips=normalSubscribtion.getTrips_num();
            normalSubscribtion.setTrips_num(trips-1);
            normalSubscribtion.setIn_use(false);
            normalSubscriptionRepo.save(normalSubscribtion);
            User user= normalSubscribtion.getUser();
            int id =user.getUser_id();
            user=userRepo.findById(id).orElse(null);
            if (user==null)
                return false;
            user.setNormalSubscribtion(normalSubscribtion);
            userRepo.save(user);
            return true;
        }
    }
}