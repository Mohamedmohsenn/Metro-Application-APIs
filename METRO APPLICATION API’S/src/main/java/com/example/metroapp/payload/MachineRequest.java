package com.example.metroapp.payload;

public class MachineRequest {
    private String type;
    private Long userID;
    private long reqID;
    private long stationID;

    public MachineRequest(String type, Long userID, long reqID, long stationID) {
        this.type = type;
        this.userID = userID;
        this.reqID = reqID;
        this.stationID = stationID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public long getReqID() {
        return reqID;
    }

    public void setReqID(long reqID) {
        this.reqID = reqID;
    }

    public long getStationID() {
        return stationID;
    }

    public void setStationID(long stationID) {
        this.stationID = stationID;
    }
}
