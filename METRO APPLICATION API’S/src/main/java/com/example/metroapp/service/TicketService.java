package com.example.metroapp.service;

import com.example.metroapp.interfaces.ITicketService;
import com.example.metroapp.model.BasicTicket;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.model.User;
import com.example.metroapp.repository.BasicTicketRepo;
import com.example.metroapp.repository.TicketRepo;
import com.example.metroapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketService implements ITicketService {
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    TripService tripService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    BasicTicketRepo basicTicketRepo;

    @Override
    public Set<Ticket> getUserTickets(Integer userID)
    {
        Set<Ticket> userTickets = userRepo.getById(userID).getTickets();
        return userTickets;
    }

    @Override
    public Integer getTicketPrice(String source,String destination)
    {
        Map<String,Boolean> getTripPath = tripService.getTripPath(source,destination);
        List<BasicTicket> allBasicTickets = basicTicketRepo.findAll();
        Map<Integer,Integer> TripsAndPrice = new TreeMap<>();
        for(BasicTicket currentTicket : allBasicTickets)
        {
            TripsAndPrice.put(currentTicket.getMaximum_trips(),currentTicket.getPrice());
        }
        Integer returnedPrice = 0;
        for(Map.Entry<Integer,Integer> mp : TripsAndPrice.entrySet()){

            if(mp.getKey() >= getTripPath.size())
            {
                returnedPrice = mp.getValue();
                break;
            }
        }
        return returnedPrice;
    }

    @Override
    public Boolean buyTicket(Integer userID, Integer price)
    {
        User user = userRepo.findById(userID).get();
        if(user.getBalance() < price)
            return false;

        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setSource_station(null);
        BasicTicket basicTicket = basicTicketRepo.findByPrice(price);
        if(basicTicket == null)
            return false;
        ticket.setMaximumTrips(basicTicket.getMaximum_trips());
        ticket.setUser(user);
        ticketRepo.save(ticket);
        user.setBalance(user.getBalance()-price);
        userRepo.save(user);
        return true;
    }
}
