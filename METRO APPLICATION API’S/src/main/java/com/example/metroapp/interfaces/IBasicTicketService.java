package com.example.metroapp.interfaces;

import com.example.metroapp.model.BasicTicket;

import java.util.List;

public interface IBasicTicketService
{
    public Boolean addBasicTicket(BasicTicket basicTicket);
    public Boolean updateBasicTicket(BasicTicket basicTicket);
    public Boolean deleteBasicTicket(BasicTicket basicTicket);
    public List<BasicTicket> selectAllBasicTicket();
}
