package com.example.metroapp.service;

import com.example.metroapp.interfaces.ITicketService;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.repository.TicketRepo;
import com.example.metroapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class TicketService implements ITicketService {
    @Autowired
    TicketRepo ticketRepo;

    @Autowired
    TripService tripService;

    @Autowired
    UserRepo userRepo;

    @Override
    public Set<Ticket> getUserTickets(Integer userID)
    {
        Set<Ticket> userTickets = userRepo.findById(userID).get().getTickets();
        return userTickets;
    }

    @Override
    public Integer getTicketPrice(String source,String destination)
    {
        Map<String,Boolean> getTripPath = tripService.getTripPath(source,destination);
        if(getTripPath.size() <= 9)
            return  5;
        else if(getTripPath.size() <= 16)
            return 7;
        else
            return  10;
    }


}
