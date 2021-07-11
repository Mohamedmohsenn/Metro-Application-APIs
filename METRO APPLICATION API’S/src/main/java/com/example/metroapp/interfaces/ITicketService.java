package com.example.metroapp.interfaces;

import com.example.metroapp.model.Ticket;

import java.util.List;
import java.util.Set;

public interface ITicketService {
    public Set<Ticket> getUserTickets(Integer userID);
    public Integer getTicketPrice(String source,String destination);
}
