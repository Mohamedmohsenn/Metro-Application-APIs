package com.example.metroapp.interfaces;

public interface IMachineService {
    public Boolean ValidateTicket(int ticketID,String stationName);
    public Boolean ValidateSub(int SubID,String stationName);
}
