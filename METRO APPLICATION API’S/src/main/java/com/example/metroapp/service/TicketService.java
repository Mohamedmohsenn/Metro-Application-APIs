package com.example.metroapp.service;

import com.example.metroapp.interfaces.ITicketService;
import com.example.metroapp.model.Ticket;
import com.example.metroapp.model.User;
import com.example.metroapp.repository.TicketRepo;
import com.example.metroapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< Updated upstream
=======
import java.util.HashMap;
import java.util.List;
>>>>>>> Stashed changes
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

    @Override
<<<<<<< Updated upstream
    public Boolean buyTicketUsingWallet(Integer userID, Integer price)
=======
    public Boolean buyTicket(Integer userID, Integer price)
>>>>>>> Stashed changes
    {
        User user = userRepo.findById(userID).get();
        if(user.getBalance() < price)
            return false;

        Ticket ticket = new Ticket();
        ticket.setPrice(price);
        ticket.setValid(true);
        if(price == 5)
            ticket.setMaximumTrips(9);
        else if(price == 7)
            ticket.setMaximumTrips(16);
        else
            ticket.setMaximumTrips(36);
        ticket.setUser(user);
        ticketRepo.save(ticket);

        user.setBalance(user.getBalance()-price);
        userRepo.save(user);
        return true;
    }
}
