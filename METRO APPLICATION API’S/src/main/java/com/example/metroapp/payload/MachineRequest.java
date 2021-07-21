package com.example.metroapp.payload;

public class MachineRequest {
    private String type;
    private int reqID;
    private String station;

    public MachineRequest(String type, int reqID, String station) {
        this.type = type;
        this.reqID = reqID;
        this.station = station;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }
}