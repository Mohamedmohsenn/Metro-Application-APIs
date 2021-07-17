package com.example.metroapp.interfaces;

public interface IMachineService {
    public Boolean ValidateTicket(long userID,long ticketID,long stationID);
    public Boolean ValidateSub(long userID,long SubID,long stationID);
}
