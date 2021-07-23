package com.example.metroapp.service;

import com.example.metroapp.interfaces.IBasicTicketService;
import com.example.metroapp.model.BasicTicket;
import com.example.metroapp.repository.BasicTicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BasicTicketService implements IBasicTicketService
{
    @Autowired
    BasicTicketRepo basicTicketRepo;

    @Override
    public List<BasicTicket> getAllBasicTickets()
    {
        return basicTicketRepo.findAll();
    }
}
