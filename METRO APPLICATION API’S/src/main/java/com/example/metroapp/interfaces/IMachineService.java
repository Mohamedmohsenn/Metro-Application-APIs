package com.example.metroapp.interfaces;

public interface IMachineService {
    public Boolean ValidateTicket(long userID,long ticketID);
    public Boolean ValidateSub(long userID,long SubID);
}
