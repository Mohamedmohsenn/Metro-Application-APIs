package com.example.metroapp.service;

import com.example.metroapp.interfaces.IMachineService;
import org.springframework.stereotype.Service;

@Service
public class MachineService implements IMachineService {
    public Boolean ValidateTicket(long userID,long ticketID,long stationID){
        return true;
    }
    public Boolean ValidateSub(long userID,long SubID,long stationID){
        return true;
    }
}
